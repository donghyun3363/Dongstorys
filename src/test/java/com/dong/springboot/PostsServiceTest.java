package com.dong.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dong.springboot.domain.posts.Posts;
import com.dong.springboot.domain.posts.PostsRepository;
import com.dong.springboot.dto.PostsSaveRequestDto;
import com.dong.springboot.service.PostsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void dto() {
		// given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("donghyun3363@gmail.com")
                .content("test")
                .title("test")
                .build();
		// when
		postsService.save(dto);
		
		// then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
		
	}
}
