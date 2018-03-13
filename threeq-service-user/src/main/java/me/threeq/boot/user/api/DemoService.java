package me.threeq.boot.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("threeq-service-upload")
public interface DemoService {
    @GetMapping("/demo")
    String hello();
}
