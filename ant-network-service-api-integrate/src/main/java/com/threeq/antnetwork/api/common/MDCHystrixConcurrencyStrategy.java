package com.threeq.antnetwork.api.common;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

import java.util.concurrent.Callable;

/**
 * @Date 2017/5/2
 * @User three
 */
public class MDCHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new MDCConcurrentCallable<>(callable);
    }
}
