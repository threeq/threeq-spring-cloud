package com.threeq.antnetwork.api.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.threeq.antnetwork.api.api.model.User;
import com.threeq.antnetwork.common.ServiceHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.http.HttpStatus.*;

/**
 * @Date 2017/4/22
 * @User three
 */
@RestController
@RequestMapping("/v1/user")
public class UserApi {

    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient client;

    @PostMapping
    @HystrixCommand(fallbackMethod = "defaultAdduser")
    public ResponseEntity<User> adduser(@RequestBody User user) {
        LOG.info(String.format("api-service adduser() invoked: POST /v1/user/"));

        String url = "http://business-user/v1/user/";

        LOG.debug("adduser from URL: {}", url);

        ResponseEntity<User> result = restTemplate.postForEntity(url, user, User.class);

        LOG.info("adduser http-status: {}", result.getStatusCode());
        LOG.debug("adduser body: {}", result.getBody());

        return ServiceHelper.createResponse(result.getBody(), result.getStatusCode());
    }

    /**
     * Fallback method
     *
     * @param user
     * @return
     */
    public ResponseEntity<User> defaultAdduser(User user) {
        LOG.warn("Fallback method for user-service is being used.");
        return new ResponseEntity<>(NO_CONTENT);
    }
}

