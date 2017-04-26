package com.threeq.antnetwork.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Date 2017/4/22
 * @User three
 */
@SpringBootApplication
@EnableHystrixDashboard
public class AntDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntDashboardApplication.class);
    }
}
