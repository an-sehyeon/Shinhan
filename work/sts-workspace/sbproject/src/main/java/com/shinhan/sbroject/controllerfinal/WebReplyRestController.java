package com.shinhan.sbroject.controllerfinal;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.sbroject.entityfinal.WebReplyDTO;
import com.shinhan.sbroject.servicefinal.WebReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WebReplyRestController {
	
	final WebReplyService replyService;
	
	// 1. 특정 Board의 댓글 조회
	@GetMapping("/board/{bno}/replies")
	public List<WebReplyDTO> f_selectAll(@PathVariable("bno") Long bno) {
		List<WebReplyDTO> replyList = replyService.getList(bno);
		return replyList;
	}
	
	// 2. 댓글 상세보기
	@GetMapping("/replies/{rno}")
	public WebReplyDTO f_detail(@PathVariable("bno") Long rno) {
		return replyService.selectById(rno);
	}
	
	// 3. 댓글 신규 입력
	@PostMapping(value = "/board/{bno}/replies")// , consumes = "application/json")
	public String f_insert(@PathVariable("bno") Long bno, @RequestBody WebReplyDTO reply) {
		reply.setBno(bno);
		int rno = replyService.register(reply);
		return rno + "- 댓글 신규 입력";
	}
	
	// 4. 댓글 수정
	@PutMapping("/replies/{rno}")
	public String f_update(@PathVariable("rno") Long rno, @RequestBody WebReplyDTO reply) {
		reply.setRno(rno);
		int updateRno = replyService.modify(reply);
		return updateRno + "- 댓글수정";
	}
	
	// 5. 댓글 삭제
	@DeleteMapping("/replies/{rno}")
	public String f_delete(@PathVariable("rno") Long rno) {
		replyService.delete(rno);
		return rno + "- 댓글삭제";
	}
}
