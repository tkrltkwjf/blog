package com.wooks.blog.application.aop;

import org.springframework.core.MethodParameter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.wooks.blog.domain.model.UserSession;

public class UserSessionArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return UserSession.class.isAssignableFrom(parameter.getParameterType());
	}
	
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavConttainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		return webRequest.getAttribute("_USER", RequestAttributes.SCOPE_REQUEST);
	}


}
