package com.shinhan.sbroject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import com.shinhan.sbroject.entity2.FreeBoardEntity;
import com.shinhan.sbroject.entity2.FreeReplyEntity;
import com.shinhan.sbroject.entity2.QFreeBoardEntity;
import com.shinhan.sbroject.repository2.FreeBoardRepository;
import com.shinhan.sbroject.repository2.FreeReplyRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class BiDirection {

	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeReplyRepository replyRepo;
	
	
	// 댓글모두 지우기
//	@Test
	void f_replyDelete() {
		replyRepo.deleteAll();
	}
	
	// 게시글 모두 지우기
//	@Test
	void f_boardDelete() {
		boardRepo.deleteAll();
	}
	
	
	// QueryDSL로 동적SQL문 만들기
	@Test
	void f_dynamicSQL() {
		String type = "title";
		String keyword = "freeboard1";
		BooleanBuilder builder = new BooleanBuilder();
		QFreeBoardEntity board = QFreeBoardEntity.freeBoardEntity;
		
		switch (type) {
		case "title" ->{ builder.and(board.title.like("%"+keyword+"%"));}
		case "writer" -> {builder.and(board.writer.like("%"+keyword+"%"));}
		case "content" ->{builder.and(board.content.like("%"+keyword+"%"));}
		}
		builder.and(board.bno.gt(0L));
		System.out.println(builder);
		Pageable page = PageRequest.of(0, 5);
		Page<FreeBoardEntity> result = boardRepo.findAll(builder, page);
		List<FreeBoardEntity>blist = result.getContent();
		
		blist.forEach(b->System.out.println(b+"댓글수:"+blist));
		System.out.println("=====page 정보 =====");
		System.out.println("getNumber : " + result.getNumber());
		System.out.println("getSize : " + result.getSize());
		System.out.println("getTotalPages : " + result.getTotalPages());
		System.out.println("getTotalElements : " + result.getTotalElements());
		}
		
	
	
	// LAB : 특정 board의 댓글만 조회
	@Transactional
//	@Test
	void f_selectReply() {
		Long bno = 23L;
		// 1) 댓글로 접근
		FreeBoardEntity board = FreeBoardEntity.builder().bno(bno).build();
		replyRepo.findByBoard(board).forEach(reply->{
			System.out.println(reply);
		});
		
		// 2) 게시글로 조회
		boardRepo.findById(bno).ifPresent(b ->{
			b.getReplies().forEach(reply->{
				System.out.println(reply);
			});
		});
	}
	
	
	// 5. board별 reply 개수
//	@Test
	void f_select() {
		boardRepo.getBoardInfo().forEach(arr->{
			System.out.println(Arrays.toString(arr));
		});
	}
	
	// 4. 조회 (board-reply)
	@Transactional
//	@Test
	void f_selectAll() {
		boardRepo.findAll().forEach(board->{
			System.out.println(board + "----댓글개수 : " + board.getReplies().size());
		});
		System.out.println("===================================");
		boardRepo.findAll().forEach(board->{
			System.out.println(board + "----!!!댓글개수 : " + board.getReplies().size());
		});
	}
	
	// 3. 존재하는 board의 reply 추가하기
//	@Test
	void f_addReply() {
		Long bno = 24L;
		FreeBoardEntity board = boardRepo.findById(bno).orElse(null);
		if(board == null) {
			System.out.println("존재하지않은 게시글입니다.");
			return;
		}
		List<FreeReplyEntity> replyList = board.getReplies();
		IntStream.rangeClosed(1,3).forEach(j ->{
			FreeReplyEntity reply = FreeReplyEntity.builder()
					.reply("여행가자"+100+":"+j)
					.replyer("user"+j)
					.board(board)			// Reply에 board
					.build();
			replyList.add(reply);
		});
		boardRepo.save(board);
	}
	
	// 2. board입력시(5건) Reply(3)도 입력
//	@Test
	void boardReplyInsert() {
		IntStream.rangeClosed(1, 5).forEach(i->{
			FreeBoardEntity board = FreeBoardEntity.builder()
					.title("freeboard" + i)
					.writer("졸지말기" + i)
					.content("작성자"+i%5)
					.build();
			List<FreeReplyEntity> replyList = new ArrayList<>();
			IntStream.range(1,3).forEach(j ->{
				FreeReplyEntity reply = FreeReplyEntity.builder()
						.reply("집중"+i+":"+j)
						.replyer("user"+j)
						.board(board)			// Reply에 board
						.build();
				replyList.add(reply);
			});
			board.setReplies(replyList);			// board에 Reply
			boardRepo.save(board);
		});
	}
	
	// 1. board만 저장하기(10건)
//	@Test
	void f_boardInsert() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			FreeBoardEntity board = FreeBoardEntity.builder()
					.title("freeboard" + i)
					.writer("SpringBoot-양방향 연관관계 연습" + i)
					.content("작성자" + i%5)
					.build();
			boardRepo.save(board);
		});
	}
}
