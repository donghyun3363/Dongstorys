package com.dong.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dong.springboot.domain.posts.PostsRepository;
import com.dong.springboot.dto.PostsMainResponseDto;
import com.dong.springboot.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
		
		List<PostsMainResponseDto> list = postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
        return list;
    }
}
