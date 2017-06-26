package com.wooks.blog.application.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wooks.blog.application.aop.CategoryInterceptor;
import com.wooks.blog.application.aop.UserSessionArgumentResolver;
import com.wooks.blog.application.aop.UserSessionInterceptor;
import com.wooks.blog.infrastructure.dao.CategoryDao;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ConnectionRepository connectionRepository;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSessionInterceptor(connectionRepository));
		registry.addInterceptor(new CategoryInterceptor(categoryDao));
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserSessionArgumentResolver());
	}
}
