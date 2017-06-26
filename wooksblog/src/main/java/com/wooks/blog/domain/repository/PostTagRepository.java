package com.wooks.blog.domain.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.wooks.blog.domain.model.UserSession;
import com.wooks.blog.domain.model.entity.Post;
import com.wooks.blog.domain.model.entity.PostTag;
import com.wooks.blog.domain.model.exception.IllegalUserException;
import com.wooks.blog.infrastructure.dao.PostDao;
import com.wooks.blog.infrastructure.dao.PostTagDao;

@Repository
public class PostTagRepository {
	@Autowired 
	PostTagDao postTagDao;
	
	@Autowired
	TagRepository tagRepository;

	public void insertPostTag(PostTag postTag) {
		postTag.setRegDate(new Date());
		postTagDao.save(postTag);
		
		tagRepository.increseUseCount(postTag.getTagId());
	}
	
	public List<PostTag> findByPostId(int postid) {
		return postTagDao.findByPostId(postid);
	}
	
	public void deletePostTag(PostTag postTag) {
		postTagDao.delete(postTag.getId());
		
		tagRepository.decreseUseCount(postTag.getTagId());
	}

}
