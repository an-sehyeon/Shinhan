package com.shinhan.sbroject.repositoryfinal;


import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shinhan.sbroject.entityfinal.QWebBoardEntity;
import com.shinhan.sbroject.entityfinal.WebBoardEntity;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;           

public interface WebBoardRepository 
		extends  JpaRepository<WebBoardEntity, Long>,
					QuerydslPredicateExecutor<WebBoardEntity>{
	
	@EntityGraph(attributePaths = "replies")
	List<WebBoardEntity> findAll();
	
	@Query("select board from WebBoardEntity board join fetch board.replies")
	List<WebBoardEntity> findAll2();
			

	// 동적SQL 만들기
	// type = "tc" keyword = "spring"
	public default Predicate makePredicate(String type, String keyword) {
		QWebBoardEntity board = QWebBoardEntity.webBoardEntity;
		BooleanBuilder builder = new BooleanBuilder();
		if (type == null)
			return builder;
		if (type.contains("t")) {
			builder.or(board.title.contains(keyword));		// or title like '%spring%'
		}
		if (type.contains("c")) {
			builder.or(board.content.contains(keyword));		// or content like '%spring%'
		}
		if (type.contains("w")) {
			builder.or(board.writer.eq(keyword));		// or writer like '%spring%'
		}
		return builder;
	}
}
