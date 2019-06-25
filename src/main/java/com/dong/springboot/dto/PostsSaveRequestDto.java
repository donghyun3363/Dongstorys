package com.dong.springboot.dto;

import com.dong.springboot.domain.posts.Posts;
import com.dong.springboot.domain.posts.Posts.PostsBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

	 private String title;
	 private String content;
	 private String author;

	 public Posts toEntity() {
		 return Posts.builder()
				 .title(title)
				 .content(content)
				 .author(author)
				 .build();
	 }
	 
	@Builder
	public PostsSaveRequestDto(String id, String content, String author, String title) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
