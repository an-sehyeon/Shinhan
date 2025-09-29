package com.shinhan.sbroject.repository2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.sbroject.entity2.FreeBoardEntity;

public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long>,
															QuerydslPredicateExecutor<FreeBoardEntity>{
	
	@EntityGraph
	Page<FreeBoardEntity> findAll(com.querydsl.core.types.Predicate builder, Pageable page);
	
	// board별 reply 개수
	@Query("select b.bno, count(r.rno) from #{#entityName} b "
			+ "left outer join b.replies r "
			+ "group by b.bno")
	List<Object[]> getBoardInfo();
	
	
	@EntityGraph(attributePaths = "replies")
	List<FreeBoardEntity> findAll();
	
	@Query("select board from #{#entityName} board join fetch board.replies")
	List<FreeBoardEntity> findAll2();
	
	
}
