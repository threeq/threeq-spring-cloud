package me.threeq.boot.user;

import me.threeq.libs.tracer.feign.FeignTracingAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("me.threeq")
@Import(FeignTracingAutoConfiguration.class)
public class AntUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntUserApplication.class);
    }
}
