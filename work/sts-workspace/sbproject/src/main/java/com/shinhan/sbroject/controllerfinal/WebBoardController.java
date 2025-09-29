package com.shinhan.sbroject.controllerfinal;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.shinhan.sbroject.aop.LoggingAdvice;
import com.shinhan.sbroject.entity.MemberEntity;
import com.shinhan.sbroject.entityfinal.WebBoardDTO;
import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.paging.PageRequestDTO;
import com.shinhan.sbroject.paging.PageResultDTO;
import com.shinhan.sbroject.repository.BoardRepository;
import com.shinhan.sbroject.repository2.EnumTypeRepository;
import com.shinhan.sbroject.servicefinal.WebBoardService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/board")
public class WebBoardController {

    private final LoggingAdvice loggingAdvice;

    private final EnumTypeRepository enumTypeRepository;

    private final BoardRepository boardRepository;
	
	@Autowired
	WebBoardService boardService;

    WebBoardController(BoardRepository boardRepository, EnumTypeRepository enumTypeRepository, LoggingAdvice loggingAdvice) {
        this.boardRepository = boardRepository;
        this.enumTypeRepository = enumTypeRepository;
        this.loggingAdvice = loggingAdvice;
    }
	
	@GetMapping("/insert.do")
	public void f_insertGet(HttpSession httpSession, Principal principal, Authentication auth, @AuthenticationPrincipal UserDetails securityUser, Model model) {
		
		MemberEntity member = (MemberEntity)httpSession.getAttribute("loginMember");
		System.out.println("세션에서 읽음 : " +  member);
		System.out.println("principal에서 읽음 : " +  principal);
		System.out.println("auth에서 읽음 : " +  auth);
		UserDetails userDetails = (UserDetails)auth.getPrincipal();
		System.out.println("auth 읽음(userDetails): " + userDetails);
		System.out.println("@AuthenticationPrincipal 읽음(userDetails): " + securityUser);
		
		String mid = securityUser.getUsername();
		model.addAttribute("mid", mid);
		
	}
	
	@PostMapping("/insert.do")
	public String f_insertPost(@ModelAttribute WebBoardDTO dto, RedirectAttributes attr) {
		int bno = boardService.register(dto);
		String message = bno+"번 게시글 insert success";
		attr.addFlashAttribute("message", message);
		return "redirect:list.do";
	}
	
	@PostMapping("/update.do")
	public String f_update(@ModelAttribute WebBoardDTO dto, RedirectAttributes attr) {
		System.out.println("수정할 board: " + dto);
		int bno = boardService.modify(dto);
		String message = bno+"번 게시글 update success";
		attr.addFlashAttribute("message", message);
		return "redirect:list.do";
	}
	
	@GetMapping("/detail.do")
	public void f_detail(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board", boardService.selectById(bno));
	}
	
	@GetMapping("/delete.do")
	public String f_delete(@RequestParam("bno") Long bno, RedirectAttributes attr) {
		int result = boardService.delete(bno);
		String message = "";
		if(result == 0) {
			message = bno + "번 게시글 delete success";
		} else {
			message = bno + "번 게시글 delete fail";
		}
		attr.addFlashAttribute("message", message);
		return "redirect:list.do";
	}
	
	// page
	@GetMapping("/list.do")
	public void f_list(Model model, PageRequestDTO pageDTO) {  // String일 경우
		System.out.println(pageDTO);
		if(pageDTO.getPage() == 0) {
			pageDTO.setPage(1);
			pageDTO.setSize(10);
		}
		
		PageResultDTO<WebBoardDTO, WebBoardEntity> responseResult = boardService.getList(pageDTO);
		model.addAttribute("boardresult",responseResult);
		model.addAttribute("pageInfo", pageDTO);
	}
	
//	@GetMapping("/list.do")
//	public void f_list(Model model) {  // String일 경우
//		List<WebBoardDTO> blist = boardService.getList();
//		model.addAttribute("boardList",blist);  // return "board/list" // classpath: resources/ 
//	}
}
