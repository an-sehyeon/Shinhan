package com.shinhan.sbroject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shinhan.sbroject.entity.BoardEntity;
import com.shinhan.sbroject.entity.QBoardEntity;
import com.shinhan.sbroject.repository.BoardRepository;

@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository boardRepo;
	@Autowired
	JPAQueryFactory factory;
	
	
	// 1. 기본 CRUD함수
	// 2. 규칙에 맞는 함수정의 findBy.....제한적, 복잡SQL불가
	// 3. JAQL...@Query, 실수할수있음
	// 4. QueryDSL 이용... 동적SQL문 자바로 만들기
	
	
//	@Test
	void f_jpaQuery() {
		String writer = "작성자 : 1";
		String content = "금요일";
		QBoardEntity board = QBoardEntity.boardEntity;
		
		List<BoardEntity> blist =  factory.selectFrom(board)
		.where(board.writer.eq(writer)
		.and(board.bno.gt(15L))
		.and(board.content.contains(content))
		).fetch();
		blist.forEach(b->System.out.println(b));
	}
	
	
	// -----------QueryDSL 이용하기
//	@Test
	void f_queryDSL1() {
		String writer = "작성자 : 1";
		String content = "금요일";
		Timestamp dt = Timestamp.valueOf("2025-08-07 15:20:58.733524");
		
		BooleanBuilder predicate = new BooleanBuilder();
		QBoardEntity board = QBoardEntity.boardEntity;
		
		predicate.and(board.bno.gt(15L));		// and bno >15
		predicate.and(board.regDate.gt(dt));		// and regDate >= '2025/08/07 0:0:0'
		predicate.and(board.writer.eq(writer));		// and writer = '작성자 : 1'
		predicate.and(board.content.contains(content));
		System.out.println("-------------------------------------------------");
		boardRepo.findAll(predicate).forEach(b-> System.out.println(b));
		System.out.println("-------------------------------------------------");
	}
	
	
	// -----------JPQL 이용하기
//	@Test
	void f_jpqlTest() {
		String writer = "작성자 : 1";
		String content = "금요일";
//		boardRepo.findAllByWriter2(writer, content).forEach(board-> System.out.println(board));
//		boardRepo.findAllByWriter3(writer, content).forEach(board-> System.out.println(board));
//		boardRepo.findAllByWriter4(writer, content).forEach(board-> System.out.println(board));
		boardRepo.findAllByWriter5(writer, content).forEach(arr->{
			System.out.println(Arrays.toString(arr));
			System.out.println("bno : " + arr[0]);
			System.out.println("title : " + arr[1]);
			System.out.println("--------------------------------------------------------");
		});
	}
	
//	@Test
	void f_test() {
		String title = "알림";
		String sd = "2025-08-07 15:20:58.733523";
		String ed = "2025-08-07 15:20:58.745879";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		
		LocalDateTime startLdt = LocalDateTime.parse(sd, formatter);
	    LocalDateTime endLdt = LocalDateTime.parse(ed, formatter);
		
		Timestamp startDate = Timestamp.valueOf(startLdt);
		Timestamp endDate = Timestamp.valueOf(endLdt);
		boardRepo.findAllByTitleContainingAndRegDateBetween(title,startDate, endDate).forEach(board->System.out.println(board));
	}
	
//	@Test
	void f_paging() {
		Long bno = 10L;
		int page=0, size=5;		// page는 0부터있음, 1은 두번째 페이지임
//		Pageable paging = PageRequest.of(page, size, Sort.by("bno").descending());
		Pageable paging = PageRequest.of(page, size, Sort.Direction.DESC, "writer");
		
		
//		boardRepo.findAll(paging).forEach(board-> System.out.println(board));
		
		Page<BoardEntity> result = boardRepo.findByBnoGreaterThanOrderByBnoAsc(bno, paging);
		System.out.println("현재 page : " + result.getNumber());
		System.out.println("현재 page의 건수 : " + result.getSize());
		System.out.println("page개수 : " + result.getTotalPages());
		System.out.println("전체개수 : " + result.getTotalElements());
		System.out.println("다음페이지 : " + result.nextPageable());
		
		List<BoardEntity> boardList = result.getContent();
		System.out.println("내용 : " + boardList);
	}
	
//	@Test
	void f_t() {
		String title = "알림";
		
//		boardRepo.findAllBytitleStartingWith(title).forEach(board -> System.out.println(board));
//		boardRepo.findAllBytitleEndingWith(title).forEach(board -> System.out.println(board));
//		boardRepo.findAllBytitleEndingWithAndBnoGreaterThan(title, 3L).forEach(board -> System.out.println(board));
		
		Long bno = 10L;
		int page=0, size=5;		// page는 0부터있음, 1은 두번째 페이지임
		Pageable paging = PageRequest.of(page, size);
		boardRepo.findByBnoGreaterThanOrderByBnoDesc(bno, paging).forEach(board -> System.out.println(board));
	}

//	@Test
	void f_title() {
		String title = "알림";
		boardRepo.findAllByTitleContaining(title).forEach(board -> System.out.println(board));
	}
	
	// 기본 CRUD 기능에 없는 경우... 규칙에 맞는 함수를 정의하여 사용한다
//	@Test
	void f_writer() {
		String writer = "작성자 : 1";
		boardRepo.findAllByWriter(writer).forEach(board -> System.out.println(board));
	}
	
	
//	@Test
	void f_delete() {
		System.out.println("전체 건수 : " + boardRepo.count());
	}
	
//	@Test
	// 특정 조건의 데이터들 삭제
	void f_deletes() {
		List<Long> idList = Arrays.asList(1L,2L,10L);
		boardRepo.deleteAllById(idList);
	}
	
//	@Test
	void deleteById() {
		boardRepo.deleteAllById(null);
	}
	
//	@Test
	void delete() {
		Long bno = 4L;
		boardRepo.deleteById(bno);
	}
	
	//@Test
	void update() {
		Long bno = 3L;
		boardRepo.findById(bno).ifPresentOrElse(board -> {
			board.setContent("수정~~~~~");
			board.setWriter("홍길동");
			boardRepo.save(board);
		},()->{
			System.out.println("존재하지않습니다.");
		});
	}
	
//	@Test
	// 특정 조건의 데이터들 조회
	void f_selectByIds() {
		List<Long> idList = Arrays.asList(1L,2L,10L);
		boardRepo.findAllById(idList).forEach(board->System.out.println(board));
	}
	
//	@Test
	// 특정 데이터만 조회
	void selectById() {
		Long bno = 30L;
		boardRepo.findById(bno).ifPresentOrElse(board -> {
			System.out.println(board);
		},()->{
			System.out.println("존재하지않습니다.");
		});
	}
	
//	@Test
	void f_select() {
		boardRepo.findAll().forEach(board->{
			System.out.println(board);
		});
	}
	
//	@Test
	void f_insert() {
		
		IntStream.rangeClosed(1, 20).forEach(i -> {
			BoardEntity board = BoardEntity.builder()
					.title("[알림] : " + i)
					.content("내일은 금요일 : " + i)
					.writer("작성자 : " + i%5) 	// 1,2,3,4,5,1,2,3,4,5
					.build();
			boardRepo.save(board);		// insert into~~
		});
		
	}
	
}
