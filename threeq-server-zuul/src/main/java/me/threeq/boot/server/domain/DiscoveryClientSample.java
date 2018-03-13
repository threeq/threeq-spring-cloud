package me.threeq.boot.server.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @Date 2017/4/22
 * @User three
 */
//@Component
public class DiscoveryClientSample implements CommandLineRunner {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(discoveryClient.description());
        discoveryClient.getInstances("restaurant-service").forEach((ServiceInstance serviceInstance) -> {
            System.out.println("Instance --> " + serviceInstance.getServiceId()
                    + "\nServer: " + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                    + "\nURI: " + serviceInstance.getUri() + "\n\n\n");
        });
    }
}
