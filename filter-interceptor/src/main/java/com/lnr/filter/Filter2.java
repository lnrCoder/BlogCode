package com.lnr.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.core.Ordered;

/**
 * @ClassName Filter2
 * @description
 * @Author lnrCoder
 * @Date 2019-10-31
 */
public class Filter2 implements javax.servlet.Filter, Ordered {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("==== filter2 doFilter 0 ====" + servletRequest.getLocalName());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("==== filter2 destroy 0 ====");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
