package me.threeq.boot.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

    @Autowired
    public DemoService demoService;

    @GetMapping("/demo")
    public String demo() {
        return demoService.hello();
    }
}
