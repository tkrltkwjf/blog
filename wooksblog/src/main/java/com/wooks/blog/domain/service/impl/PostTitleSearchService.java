package com.wooks.blog.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wooks.blog.domain.model.entity.Post;
import com.wooks.blog.domain.repository.PostSearchRepository;
import com.wooks.blog.domain.service.PostSearchService;

@Service("title")
public class PostTitleSearchService implements PostSearchService {
	
	@Autowired
	private PostSearchRepository postSearchRepository;

	@Override
	public Page<Post> findPost(String query, Pageable pageable) {
		// TODO Auto-generated method stub
		return postSearchRepository.findPostByTitle(query, pageable);
	}

}
