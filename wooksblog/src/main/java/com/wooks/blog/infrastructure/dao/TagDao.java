package com.wooks.blog.infrastructure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wooks.blog.domain.model.entity.Tag;

public interface TagDao extends JpaRepository<Tag, Integer> {
	Tag findByName(String tagName);
}
