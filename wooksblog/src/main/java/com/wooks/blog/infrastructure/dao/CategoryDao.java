package com.wooks.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wooks.blog.domain.model.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
