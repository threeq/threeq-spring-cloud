package me.threeq.boot.server;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.turbine.stream.HystrixStreamAggregator;
import org.springframework.cloud.netflix.turbine.stream.TurbineStreamClient;
import org.springframework.cloud.netflix.turbine.stream.TurbineStreamProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Payload;
import rx.subjects.PublishSubject;

/**
 * Autoconfiguration for a Spring Cloud Turbine using Spring Cloud Stream. Enabled by
 * default if spring-cloud-stream is on the classpath, and can be switched off with
 * <code>turbine.stream.enabled</code>.
 *
 * @author Spencer Gibb
 * @author Dave Syer
 */
@Configuration
@ConditionalOnClass(EnableBinding.class)
@EnableBinding(TurbineStreamClient.class)
public class TurbineStreamAutoConfiguration {

    @Autowired
    private BindingServiceProperties bindings;

    @Autowired
    private TurbineStreamProperties properties;

    @PostConstruct
    public void init() {
        BindingProperties inputBinding = this.bindings.getBindings()
                .get(TurbineStreamClient.INPUT);
        if (inputBinding == null) {
            this.bindings.getBindings().put(TurbineStreamClient.INPUT,
                    new BindingProperties());
        }
        BindingProperties input = this.bindings.getBindings()
                .get(TurbineStreamClient.INPUT);
        if (input.getDestination() == null) {
            input.setDestination(this.properties.getDestination());
        }
        if (input.getContentType() == null) {
            input.setContentType(this.properties.getContentType());
        }
    }

    @Bean
    public HystrixStreamAggregator hystrixStreamAggregator(ObjectMapper mapper,
                                                           PublishSubject<Map<String, Object>> publisher) {
        return new HystrixStreamAggregator(mapper, publisher){
            @ServiceActivator(inputChannel = TurbineStreamClient.INPUT)
            public void sendToSubject(@Payload String payload) {
                if (payload.startsWith("\"")) {
                    // Legacy payload from an Angel client
                    payload = payload.substring(1, payload.length() - 1);
                    payload = payload.replace("\\\"", "\"");
                }
                if (!payload.startsWith("[") && !payload.startsWith("{")) {
                    List<Byte> byteList = Arrays.stream(payload.split(","))
                            .map(Byte::valueOf)
                            .collect(Collectors.toList());
                    byte[] bytes = new byte[byteList.size()];
                    for(int i=0; i<byteList.size(); i++) {
                        bytes[i] = byteList.get(i);
                    }
                    payload = new String(bytes);
                }
                super.sendToSubject(payload);

            }
        };
    }

}
