package com.threeq.antnetwork.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaServer
public class AntEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntEurekaApplication.class);
    }
}
