package com.wooks.blog.domain.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	int id;
	
	int postId;
	
	String userId;
	String name;
	
	String content;
	
	Date regDate;
}
