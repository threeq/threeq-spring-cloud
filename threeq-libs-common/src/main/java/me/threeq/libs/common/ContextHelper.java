package me.threeq.libs.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ContextHelper {
    public static ServletRequestAttributes attributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }

    public static HttpServletRequest request() {
        return attributes().getRequest();
    }
}
