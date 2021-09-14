package com.pt15305ud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pt15305ud.service.CategoryService;

@Component
public class GlobalInterceptoer implements HandlerInterceptor{
@Autowired
CategoryService cSer;

@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	request.setAttribute("categories", cSer.findAll());
}
	
	
}
