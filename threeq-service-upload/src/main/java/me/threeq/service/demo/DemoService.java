package me.threeq.service.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String hello() {
        return "hello, demo";
    }
}
