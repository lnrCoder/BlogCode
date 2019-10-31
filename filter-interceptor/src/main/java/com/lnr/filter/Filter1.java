package com.lnr.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.core.Ordered;

/**
 * @ClassName Filter1
 * @description
 * @Author lnrCoder
 * @Date 2019-10-31
 */
public class Filter1 implements javax.servlet.Filter, Ordered {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("==== filter1 doFilter LOWEST ====" + servletRequest.getLocalAddr());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("==== filter1 destroy LOWEST ====");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
