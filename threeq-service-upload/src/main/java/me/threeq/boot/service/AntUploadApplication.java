package me.threeq.boot.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "me.threeq")
public class AntUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntUploadApplication.class);
    }
}
