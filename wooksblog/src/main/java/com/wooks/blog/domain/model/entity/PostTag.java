package com.wooks.blog.domain.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "post")
@Entity
@NoArgsConstructor
public class PostTag {
	
	public PostTag(int postId,int tagId) {
		this.regDate = new Date(); 
		this.postId = postId; 
		this.tagId = tagId; 

	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId",insertable = false, updatable = false)
	private Post post;
	
	private int postId;
	
	@ManyToOne
	@JoinColumn(name = "tagId",insertable = false, updatable = false)
	private Tag tag;
	
	private int tagId;
	
	private Date regDate;
}
