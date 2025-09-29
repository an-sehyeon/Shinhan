package com.shinhan.sbroject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.sbroject.dto.GuestBookDTO;
import com.shinhan.sbroject.entity.GuesttBookEntity;
import com.shinhan.sbroject.repository.GuestBookRepository;

// Controller가 요청하면 service -> repository
//				<-						   <-
@Service
public class GuestBookService {
	
	@Autowired
	GuestBookRepository gRepo;
	
	// 모두조회
	public List<GuestBookDTO> selectAll() {
		List<GuesttBookEntity> booklist = (List<GuesttBookEntity>)gRepo.findAll();
		
		List<GuestBookDTO> booklist2 = booklist.stream().map(entity-> entityToDTO(entity))
														.collect(Collectors.toList());
		
		return booklist2;
	}
	
	
	// 조회시 사용
	public GuestBookDTO entityToDTO(GuesttBookEntity entity) {
		
		ModelMapper modelMapper = new ModelMapper();
		GuestBookDTO dto = modelMapper.map(entity,  GuestBookDTO.class);
		dto.setDescription("이름이 다른 field는 직접setting필요함");
		
		/*
		 * GuestBookDTO dto = GuestBookDTO.builder() .gno(entity.getGno())
		 * .title(entity.getTitle()) .writer(entity.getWriter())
		 * .content(entity.getContent()) .regDate(entity.getRegDate())
		 * .modDate(entity.getModDate()) .build();
		 */
		return dto;
	}
	
	// controller에서 들어온 DTO를 Repository에 전달전에 사용
	// insert, update시에 사용
	public GuesttBookEntity dtoToBookEntity(GuestBookDTO dto) {
		
		GuesttBookEntity entity = GuesttBookEntity.builder()
				.gno(dto.getGno())
				.title(dto.getTitle())
				.writer(dto.getWriter())
				.content(dto.getContent())
				.build();
		
		return entity;
	}
}
