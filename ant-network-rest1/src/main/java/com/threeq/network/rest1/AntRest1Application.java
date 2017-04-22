package com.threeq.network.rest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
public class AntRest1Application {

    public static void main(String[] args) {
        SpringApplication.run(AntRest1Application.class);
    }
}
