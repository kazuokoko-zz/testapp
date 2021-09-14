package com.pt15305ud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pt15305ud.interceptor.GlobalInterceptoer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
@Autowired
GlobalInterceptoer globalInterceptoer;

@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptoer)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/admin/**","/assets/**");
	}
}
