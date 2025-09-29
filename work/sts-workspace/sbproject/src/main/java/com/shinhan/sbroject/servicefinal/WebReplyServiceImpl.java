package com.shinhan.sbroject.servicefinal;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.entityfinal.WebReplyDTO;
import com.shinhan.sbroject.entityfinal.WebReplyEntity;
import com.shinhan.sbroject.repositoryfinal.WebReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WebReplyServiceImpl implements WebReplyService{

	
	final WebReplyRepository replyRepo;


	@Override
	public List<WebReplyDTO> getList(Long bno) {
		ModelMapper mapper = new ModelMapper();
		WebBoardEntity board = WebBoardEntity.builder().bno(bno).build();
		List<WebReplyEntity> replies =  replyRepo.findByBoard(board);
		List<WebReplyDTO> dtoList = replies.stream().map(entity->{
			WebReplyDTO dto = mapper.map(entity, WebReplyDTO.class);
			dto.setBno(bno);
			return dto;
		}).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public WebReplyDTO selectById(Long rno) {
		WebReplyEntity entity = replyRepo.findById(rno).orElse(null);
		if(entity == null) return null;
		ModelMapper mapper = new ModelMapper();
		WebReplyDTO dto = mapper.map(entity, WebReplyDTO.class);
		dto.setBno(entity.getBoard().getBno());
		return dto;
	}

	@Override
	public int register(WebReplyDTO reply) {
		return f_save(reply);
	}

	@Override
	public int modify(WebReplyDTO reply) {
		return f_save(reply);
	}

	// 입력, 수정의 공통로직임 DTO->entity->DB
	private int f_save(WebReplyDTO reply) {
		ModelMapper mapper = new ModelMapper();
		
		WebReplyEntity entity = mapper.map(reply, WebReplyEntity.class);
		
			WebBoardEntity board = WebBoardEntity.builder().bno(reply.getBno()).build();
			entity.setBoard(board);
			
		WebReplyEntity newEntity = replyRepo.save(entity);
		return newEntity.getRno().intValue();
	}

	@Override
	public int delete(Long rno) {
		replyRepo.deleteById(rno);
		
		WebReplyEntity entity = replyRepo.findById(rno).orElse(null);
		if(entity == null) return 0;
		
		return 1;
	}

}
