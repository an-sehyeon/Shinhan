package com.shinhan.sbroject.servicefinal;

import java.util.List;

import com.shinhan.sbroject.entityfinal.WebReplyDTO;

public interface WebReplyService {

	// 1. 조회
	List<WebReplyDTO> getList(Long bno);
	
	// 2. 상세보기
	WebReplyDTO selectById(Long rno);
	
	// 3. 입력
	int register(WebReplyDTO reply); 
	
	// 4. 댓글수정
	int modify(WebReplyDTO reply);
	
	// 5. 삭제
	int delete(Long rno);

}
