package com.threeq.antnetwork.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Date 2017/5/9
 * @User three
 */
@SpringBootApplication
@EnableConfigServer
public class AntConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AntConfigServerApplication.class, args);
    }
}
