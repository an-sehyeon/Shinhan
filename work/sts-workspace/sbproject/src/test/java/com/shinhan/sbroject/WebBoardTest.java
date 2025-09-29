package com.shinhan.sbroject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.querydsl.core.types.Predicate;
import com.shinhan.sbroject.entityfinal.WebBoardDTO;
import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.entityfinal.WebReplyEntity;
import com.shinhan.sbroject.paging.PageRequestDTO;
import com.shinhan.sbroject.paging.PageResultDTO;
import com.shinhan.sbroject.repositoryfinal.WebBoardRepository;
import com.shinhan.sbroject.repositoryfinal.WebReplyRepository;

import jakarta.transaction.Transactional;

/*
 * tbl_webboard : 10건 입력
 * tbl_webboard(20건) + tbl_webreply(5건)
 * */

@SpringBootTest
public class WebBoardTest {
	
	@Autowired
	WebBoardRepository boardRepo;
	
	@Autowired
	WebReplyRepository replyRepo;

	WebBoardDTO entityToDTO(WebBoardEntity entity) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(entity, WebBoardDTO.class);
	}
	
//	@Test
	void f_paging() {
		String type = "t";
		String keyword = "스프링";
		PageRequestDTO pageDto = PageRequestDTO.builder()
				.page(1)
				.size(2)
				.type(type)
				.keyword(keyword)
				.build();
		Sort sort = Sort.by(Direction.ASC, "bno");
		Pageable pageable = pageDto.getPageable(sort);
		Predicate Predicate = boardRepo.makePredicate(type, keyword);
		Page<WebBoardEntity> result =  boardRepo.findAll(Predicate, pageable);
		Function<WebBoardEntity, WebBoardDTO> fn = entity-> entityToDTO(entity);
		PageResultDTO<WebBoardDTO, WebBoardEntity> 
			responseResult = new PageResultDTO<>(result, fn); 
		System.out.println("=============="+responseResult.getDtoList());
		System.out.println("=============="+responseResult.getStart());
		System.out.println("=============="+responseResult.getEnd());
		System.out.println("=============="+responseResult.getPageList());
	}
	
//	@Transactional		// board가 (LAZY)인 상황, reply를 select하고자하는 업무
//	@Test
	void f_selectAllBoard2() {
		boardRepo.findAll().forEach(board->{
			System.out.println(board);
			System.out.println(board.getReplies());
			System.out.println("---------------------------------------------------");
	});
	}
	
//	@Test
	void f_replySelectByBoard() {
		WebBoardEntity board = WebBoardEntity.builder().bno(60L).build();
		replyRepo.findByBoard(board).forEach(reply->{
			System.out.println(reply);
		});
	}
	
	
//	@Test
	void selectAll() {
		List<WebBoardEntity> boardList = boardRepo.findAll();
		ModelMapper mapper = new ModelMapper();
		List<WebBoardDTO> dtoList = boardList.stream().map(entity->mapper.map(entity, WebBoardDTO.class))
				.collect(Collectors.toList());
		
		dtoList.forEach(dto->{
			System.out.println(dto);
		});
	}
	
	
	// 댓글번호 : 296, 297, 298, 299, 300 가 1번 board 의 댓글로 수정
//	@Test
	void f_update() {
		Long[] idArr = {296L,297L,298L,299L,300L};
		WebBoardEntity board = WebBoardEntity.builder().bno(60L).build();
		Arrays.stream(idArr).forEach(rno ->{
			WebReplyEntity reply = replyRepo.findById(rno).orElse(null);
			if(reply!=null) {
				reply.setBoard(board);
				replyRepo.save(reply);
			}
		});
	}
	
	// 1번 board의 댓글추가 5건추가
//	@Test
	void f_insert3() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			WebBoardEntity board = WebBoardEntity.builder().bno(60L).build();
			WebReplyEntity reply = WebReplyEntity.builder()
					.replyText("화요일 회식")
					.replyer("user4")
					.board(board)
					.build();
			replyRepo.save(reply);
		});
	}
	
	
//	@Test
	void boardReplyInsert() {
		IntStream.rangeClosed(21, 40).forEach(i->{
			WebBoardEntity board = WebBoardEntity.builder()
					.title("스프링"+i)
					.writer("김길자"+i)
					.content("내요오옹"+i)
					.build();
			List<WebReplyEntity> replyList = new ArrayList<>();
			IntStream.rangeClosed(1, 5).forEach(j->{
				WebReplyEntity reply = WebReplyEntity.builder()
						.replyText("문자"+i+":"+j)
						.replyer("댓글"+j)
						.board(board)
						.build();
				replyList.add(reply);
			});
			board.setReplies(replyList);
			boardRepo.save(board);
		});
	}
	
	
//	@Test
	void f_insert() {
		IntStream.rangeClosed(1, 20).forEach(i->{
			WebBoardEntity board = WebBoardEntity.builder()
					.title("spring"+i)
					.writer("user"+i)
					.content("스프링~~~~"+i)
					.build();
			boardRepo.save(board);
		});
	}

}
