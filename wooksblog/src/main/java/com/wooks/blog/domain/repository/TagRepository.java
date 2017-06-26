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
import com.wooks.blog.domain.model.entity.Tag;
import com.wooks.blog.domain.model.exception.IllegalUserException;
import com.wooks.blog.infrastructure.dao.PostDao;
import com.wooks.blog.infrastructure.dao.PostTagDao;
import com.wooks.blog.infrastructure.dao.TagDao;

@Repository
public class TagRepository {
	
	@Autowired 
	private TagDao tagDao; 

	public Tag findTagByTagName(String tagName) {
		
		return tagDao.findByName(tagName);
	}
	
	public Tag createTag(Tag tag) {
		
		tag.setRegDate(new Date());
		return tagDao.save(tag);
	}
	
	public void increseUseCount(int tagIdx) {
		
		Tag tag = tagDao.findOne(tagIdx);
		tag.setUpdateDate(new Date());
		tag.setUseCount(tag.getUseCount() + 1);
	}
	
	public void decreseUseCount(int tagIdx) {
		
		Tag tag = tagDao.findOne(tagIdx);
		tag.setUpdateDate(new Date());
		tag.setUseCount(tag.getUseCount() - 1);
	}
	
	public Page<Tag> findAll(Pageable pageable) {
		
		Page<Tag> tags = tagDao.findAll(pageable);
		return tags;
	}
}
