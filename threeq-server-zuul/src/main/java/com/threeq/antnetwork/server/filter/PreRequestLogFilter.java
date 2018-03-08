package com.threeq.antnetwork.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.threeq.antnetwork.server.constant.ZuulConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

    @Override
    public String filterType() {
        return ZuulConstant.FILTER_TYPE_PRE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 业务逻辑实现
        return null;
    }
}
