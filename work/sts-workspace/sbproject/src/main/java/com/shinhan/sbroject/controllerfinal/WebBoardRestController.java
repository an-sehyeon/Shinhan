package com.shinhan.sbroject.controllerfinal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.sbroject.entityfinal.WebBoardDTO;
import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.paging.PageRequestDTO;
import com.shinhan.sbroject.paging.PageResultDTO;
import com.shinhan.sbroject.servicefinal.WebBoardService;

@RestController
@RequestMapping("/api/board")
public class WebBoardRestController {
 
	@Autowired
	WebBoardService boardService;

   
	@PostMapping("/insert.do")
	public String f_insertPost(@RequestBody WebBoardDTO dto,
			    @AuthenticationPrincipal UserDetails userDetails) {
		
		String mid = userDetails.getUsername();
		dto.setWriter(mid);
		System.out.println(mid);
		System.out.println(dto );

		
		int bno = boardService.register(dto);
		String message = bno + "번 게시글 insert success";
        return message;

	}
	
	@PutMapping("/update.do")
	public String f_update(@RequestBody WebBoardDTO dto) {
		int bno = boardService.modify(dto);
		String message = bno + "번 게시글 update success";
		return message;
	}
	
	@GetMapping("/detail.do/{bno}")
    public WebBoardDTO f_detaile(@PathVariable("bno") Long bno ) {		
		return boardService.selectById(bno);
	}
	
	@DeleteMapping("/delete.do/{bno}")
    public String f_delete(@PathVariable("bno") Long bno ) {		
		int result = boardService.delete(bno);
		String message = "";
		if(result == 0 )
			message = bno + "번 게시글 delete success";
		else
			message = bno + "번 게시글 delete fail";		
		 
		return message;
		 
		
	}
	
 
	@GetMapping("/listAll.do")
	public List<WebBoardDTO> f_list( ) {
		List<WebBoardDTO> blist = boardService.getList();
		return blist;
		 
	}
	
	
	@GetMapping("/list.do")
	public Map<String, Object> f_list(PageRequestDTO pageDTO) {
		//PageRequestDTO가 없으면 : PageRequestDTO(page=0, size=0, type=null, keyword=null)
		 
		if(pageDTO.getPage() == 0) {	 
			pageDTO.setPage(1);
			pageDTO.setSize(10);
		}
		PageResultDTO<WebBoardDTO, WebBoardEntity> 
		     responseResult = boardService.getList(pageDTO);		
		Map<String, Object> map = new HashMap<>();
		map.put("boardresult", responseResult);
		map.put("pageInfo",pageDTO);
		
		return map;
	}
	
	
	
 
	
}