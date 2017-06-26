package com.wooks.blog.infrastructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wooks.blog.domain.model.entity.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {
	List<Comment> findByPostId(int postId);
}
