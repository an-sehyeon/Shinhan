package com.shinhan.sbroject.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.shinhan.sbroject.entity.BoardEntity;

// Repository 설계... Hibernate 가 interface 를 이용해서 구현
// 
// Repository <- CrudRepository <- pagingAnsSortRepository <- JPARepository
public interface BoardRepository extends CrudRepository<BoardEntity, Long>,
										PagingAndSortingRepository<BoardEntity, Long>,
										QuerydslPredicateExecutor<BoardEntity>{
	
	// 3. JPQL(JPA Query Language) .. SQL문이 복잡한 경우, 함수이름 규칙없음
	@Query("select board from BoardEntity board " +
		       "where board.writer = ?1 and board.content like %?2%" +
		       "order by board.bno asc")
		List<BoardEntity> findAllByWriter2(String writer, String content);

	
	// entity이름 직접 사용안함, param을 순서로 하지않고 이름 사용
	@Query("select board from #{#entityName} board "
			+ "where board.writer = :ww and board.content like %:cc% order by board.bno desc")
	List<BoardEntity> findAllByWriter3(@Param("ww") String  writer, @Param("cc") String content);
	
	// nativeQuery : MariaDB문법
	@Query(value = "select * from t_board "
			+ " where writer = ?1 "
			+ " and content like concat('%' , ?2 , '%') order by bno asc", nativeQuery = true)
	List<BoardEntity> findAllByWriter4(String writer, String content);
	
	@Query("select board.bno, board.title from #{#entityName} board "
			+ "where board.writer = :ww and board.content like %:cc% order by board.bno desc")
	List<Object[]> findAllByWriter5(@Param("ww") String  writer, @Param("cc") String content);

	// 1. 기본CRUD제공하는 함수는 제공... > findAll(), findById, save(), count()...
	// 2. 기본 CRUD 기능에 없는 경우... 규칙에 맞는 함수를 정의하여 사용한다.
	List<BoardEntity> findAllByWriter(String writer);		//where writer = ?
	List<BoardEntity> findAllByTitleContaining(String Title);		//where like '%'||?||'%'
	List<BoardEntity> findAllByTitleStartingWith(String T);		//where title like ?||'%'
	List<BoardEntity> findAllByTitleEndingWith(String T);		//where title like '%'||?
	List<BoardEntity> findAllByTitleEndingWithAndBnoGreaterThan(String T, Long bno);		//where title like '%'||? and bno > 10, 다중 조회
	List<BoardEntity> findAllByTitleContainingAndRegDateBetween(String T, Timestamp sd, Timestamp ed);		
	
	// paging추가
	List<BoardEntity> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	Page<BoardEntity> findByBnoGreaterThanOrderByBnoAsc(Long bno, Pageable paging);
}
