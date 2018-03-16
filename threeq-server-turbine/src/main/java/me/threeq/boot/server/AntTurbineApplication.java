package me.threeq.boot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class AntTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntTurbineApplication.class);
    }
}
