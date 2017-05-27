package com.threeq.antnetwork.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class AntZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(AntZipkinApplication.class, args);
    }
}
