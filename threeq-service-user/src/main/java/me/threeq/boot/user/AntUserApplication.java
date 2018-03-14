package me.threeq.boot.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrix
@ComponentScan("me.threeq")
public class AntUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntUserApplication.class);
    }
}
