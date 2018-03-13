package me.threeq.boot.service.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String hello() {
        return "hello, demo";
    }
}
