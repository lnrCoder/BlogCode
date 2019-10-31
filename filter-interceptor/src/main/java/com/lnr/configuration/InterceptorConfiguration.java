package com.lnr.configuration;

import com.lnr.interceptor.Interceptor1;
import com.lnr.interceptor.Interceptor2;
import com.lnr.interceptor.Interceptor3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName InterceptorConfiguration
 * @description
 * @Author lnrCoder
 * @Date 2019-10-31
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor1())
                .addPathPatterns("/**");
        registry.addInterceptor(new Interceptor2())
                .addPathPatterns("/**");
        registry.addInterceptor(new Interceptor3())
                .addPathPatterns("/**");
    }
}
