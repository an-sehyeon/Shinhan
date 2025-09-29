package com.shinhan.sbroject.repositoryfinal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.entityfinal.WebReplyEntity;

public interface WebReplyRepository extends JpaRepository<WebReplyEntity, Long>{

	// 규칙에 맞는 함수를 정의
	List<WebReplyEntity> findByBoard(WebBoardEntity board);
}
