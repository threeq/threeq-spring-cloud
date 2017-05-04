package com.threeq.antnetwork.api;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.threeq.antnetwork.api.common.MDCHystrixConcurrencyStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class AntApiApplication {
    private static final Logger LOG = LoggerFactory.getLogger(AntApiApplication.class);

    public static void main(String[] args) {
        LOG.info("Register MDCHystrixConcurrencyStrategy");
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new MDCHystrixConcurrencyStrategy());
        SpringApplication.run(AntApiApplication.class);
    }
}
