package com.threeq.antnetwork.reactive.api;

import com.threeq.antnetwork.reactive.model.TestModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Date 2017/4/20
 * @User three
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    @GetMapping
    public Flux<TestModel> test(){
        TestModel[] testData = {
                new TestModel(),
                new TestModel()
        };
        return Flux.fromArray(testData);
    }

    @PatchMapping
    public String test2() {
        return "222";
    }

    @PostMapping
    public Mono<TestModel> test3() {
        return Mono.justOrEmpty(new TestModel());
    }
}