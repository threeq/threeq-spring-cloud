package me.threeq.libs.common.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {
    @Bean
    public ServletListenerRegistrationBean<?> registerCustomListener() {
        return new ServletListenerRegistrationBean<>(new RequestIdListener());
    }
}
