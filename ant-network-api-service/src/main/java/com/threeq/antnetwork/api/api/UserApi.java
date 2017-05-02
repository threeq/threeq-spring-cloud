package com.threeq.antnetwork.api.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2017/4/22
 * @User three
 */
@RestController
@RequestMapping("/v1/user")
public class UserApi {

    @GetMapping
    public String user() {
        return "user";
    }
}
