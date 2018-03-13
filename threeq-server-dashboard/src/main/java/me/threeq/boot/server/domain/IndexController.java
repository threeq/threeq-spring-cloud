package me.threeq.boot.server.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 2017/4/22
 * @User three
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

}
