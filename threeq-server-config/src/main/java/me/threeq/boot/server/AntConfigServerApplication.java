package me.threeq.boot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Date 2017/5/9
 * @User three
 */
@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AntConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AntConfigServerApplication.class, args);
    }
}
