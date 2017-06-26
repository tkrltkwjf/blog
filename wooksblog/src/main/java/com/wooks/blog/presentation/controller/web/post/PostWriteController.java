package com.wooks.blog.presentation.controller.web.post; 



import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import com.wooks.blog.domain.model.UserSession;
import com.wooks.blog.domain.model.command.PostCommand;
import com.wooks.blog.domain.repository.CategoryRepository;
import com.wooks.blog.domain.service.PostService;
 

 
 @Controller 
 @RequestMapping("/post/write") 
 public class PostWriteController { 
	 
	@Autowired
	private PostService postService;
	
	@Autowired
	private CategoryRepository categoryRepository;

 	@RequestMapping(method = RequestMethod.GET) 
 	public String form(PostCommand post,Model model) {
 		
 		model.addAttribute("categoryMap",categoryRepository.getCategoryMap());
 		
 		return "post/form"; 
 	} 
 
 	@RequestMapping(method = RequestMethod.POST) 
 	public String write(@Valid PostCommand post, BindingResult bindingResult,UserSession user,Model model) {
 		model.addAttribute("categoryMap", categoryRepository.getCategoryMap());
 		
 		if (bindingResult.hasErrors()) { 
 			return "post/form"; 
 		} 

 		return "redirect:/post/" + postService.writePost(post, user).getId(); 
 	} 
 	
} 
