package com.wooks.blog.application.configuration;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wooks.blog.domain.service.factory.SearchServiceFactory;

@Configuration
public class BlogConfig {
	
	@Bean
	public ServiceLocatorFactoryBean searchFactoryServiceLocatorFactoryBean() {
		ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(SearchServiceFactory.class);
		return bean;
	}
		
	@Bean
	public SearchServiceFactory searchServiceFactory() {
		return (SearchServiceFactory) searchFactoryServiceLocatorFactoryBean().getObject();
	}
	

}
