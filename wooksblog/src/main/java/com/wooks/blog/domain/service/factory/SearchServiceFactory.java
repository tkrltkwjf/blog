package com.wooks.blog.domain.service.factory;

import com.wooks.blog.domain.service.PostSearchService;

public interface SearchServiceFactory {
	PostSearchService getSearchService(String selector);
}
