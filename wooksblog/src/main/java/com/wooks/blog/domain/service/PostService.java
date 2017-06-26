package com.wooks.blog.domain.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wooks.blog.domain.model.UserSession;
import com.wooks.blog.domain.model.command.PostCommand;
import com.wooks.blog.domain.model.entity.Post;
import com.wooks.blog.domain.model.exception.IllegalUserException;
import com.wooks.blog.domain.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TagService tagService;

	@Transactional
	public Post writePost(PostCommand postCommand,UserSession user) {
		
		postCommand.setUserId(user.getProviderUserId());
		postCommand.setName(user.getDisplayName());
		
		Post post = postRepository.writePost(new Post(postCommand));
		
		postCommand.setId(post.getId());
		
		tagService.insertPostTag(postCommand);
		
		return post;
	}
	
	@Transactional
	public Post editPost(PostCommand postCommand, UserSession user) throws RuntimeException { 
	
	
		if (!postRepository.isThisUserPostWriter(user, postCommand.getId())) { 
			throw new IllegalUserException("Not the Writer."); 
		} 
	
	
		Post post = postRepository.editPost(postCommand); 
	
	
		tagService.updatePostTag(postCommand); 
	
	
		return post; 
	} 
	
	@Transactional
	public void deletePost(int postId, UserSession user) throws IllegalUserException, IllegalArgumentException { 
	
	
		if (!postRepository.isThisUserPostWriter(user, postId)) { 
			throw new IllegalUserException("Not the Writer."); 
		} 
	
	
		tagService.deletePostTagByPostId(postId); 
	
	
		postRepository.deletePost(postId); 
	} 


}
