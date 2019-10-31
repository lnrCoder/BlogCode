package com.lnr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName Interceptor2
 * @description
 * @Author lnrCoder
 * @Date 2019-10-31
 */
public class Interceptor2 implements HandlerInterceptor, Ordered {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        System.out.println("CustomInterceptor....preHandle 2" + httpServletRequest.getRequestURI());
        //对浏览器的请求进行放行处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
            ModelAndView modelAndView) {
        System.out.println("CustomInterceptor....postHandle 2" + httpServletRequest.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Object o, Exception e) {
        System.out.println("CustomInterceptor....afterCompletion 2" + httpServletRequest.getRequestURI());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
