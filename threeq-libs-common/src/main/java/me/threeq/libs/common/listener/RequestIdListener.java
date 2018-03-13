package me.threeq.libs.common.listener;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RequestIdListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        String requestId = UUID.randomUUID().toString();
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String xRequestId = httpRequest.getHeader("x-request-id");
            if(!StringUtils.isEmpty(xRequestId)) {
                requestId = xRequestId;
            }
        }
        request.setAttribute("RequestId", requestId);
        sre.getServletContext().setAttribute("RequestId", requestId);

        MDC.put("RequestId", requestId);

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        MDC.clear();
    }
}
