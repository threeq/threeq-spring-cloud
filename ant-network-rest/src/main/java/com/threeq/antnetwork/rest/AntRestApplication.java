package com.threeq.antnetwork.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
public class AntRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntRestApplication.class);
    }
}
