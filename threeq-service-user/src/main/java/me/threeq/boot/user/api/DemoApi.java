package me.threeq.boot.user.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

    @Autowired
    public DemoService demoService;

    @GetMapping("/demo")
    @HystrixCommand(fallbackMethod = "defaultDemo")
    public String demo() {
        return demoService.hello();
    }

    /**
     * Fallback method
     *
     * @return
     */
    public String defaultDemo() {
        return "demo 接口出错，默认返回";
    }
}
