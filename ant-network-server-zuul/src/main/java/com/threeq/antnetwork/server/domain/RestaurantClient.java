package com.threeq.antnetwork.server.domain;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * @Date 2017/4/22
 * @User three
 */
@FeignClient("restaurant-service")
public interface RestaurantClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/restaurants")
    Collection<String> getRestaurants(@RequestParam("name") String name);
}
