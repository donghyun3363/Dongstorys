package com.dong.springboot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.dong.springboot.domain.posts.Posts;
import com.dong.springboot.domain.posts.PostsRepository;

import antlr.collections.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	 @Autowired
	    PostsRepository postsRepository;

	    @After
	    public void cleanup() {
	        /** 
	        이후 테스트 코드에 영향을 끼치지 않기 위해 
	        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
	        **/
	        postsRepository.deleteAll();
	    }

	    @Test
	    public void 게시글저장_불러오기() {
	        //given
	        postsRepository.save(Posts.builder()
	                .title("테스트 게시글")
	                .content("테스트 본문")
	                .author("jojoldu@gmail.com")
	                .build());

	        //when
	        java.util.List<Posts> postsList = postsRepository.findAll();

	        //then
	        Posts posts = postsList.get(0);
	        assertThat(posts.getTitle(), is("테스트 게시글"));
	        assertThat(posts.getContent(), is("테스트 본문"));
	    }
}
