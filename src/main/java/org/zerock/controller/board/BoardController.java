package org.zerock.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.board.BoardDto;
import org.zerock.service.board.BoardSerivce;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardSerivce service;

	@GetMapping("register")
	public void register() {
		// 게시물 작성 view로 포워드
		// /WEB-INF/views/board/register.jsp
		
	}
	
	@PostMapping("register")
	public String register(BoardDto board, RedirectAttributes rttr) {
		// request param 수집/가공
		System.out.println(board);
		
		// business logic
		int cnt = service.register(board);
		
		if (cnt ==1) {
			rttr.addFlashAttribute("message","새 게시물이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message","새 게시물이 등록되지 않았습니다.");
		}
		
		// /board/list로 redirect 
		return "redirect:/board/list";
	
	}
	
	@GetMapping("list")
	public void list(Model model) {
		// request param 수집
		// business logic
		List<BoardDto> list = service.listBoard();
		// add attriubute
		// jsp에서 boardlist이름을로 꺼냈으니 boardlist사용 
		model.addAttribute("boardList", list);
		// forward
		
	}
	
	@GetMapping("get")
	public void get(
				// @requestparam 생략 가능 
			@RequestParam(name = "id") int id,
			Model model) {
		// @requestparam
		
		// business logic 으로 (게시물 db에서 가져오기)
		BoardDto board = service.get(id);
		// att attribute (model에서 attribute얻고)
		System.out.println(board);
		model.addAttribute("board",board);
		// forward/redirect
		
	}
	
	@GetMapping("modify")
	public void modify(int id, Model model) {
		BoardDto board = service.get(id);
		model.addAttribute("board", board);
	}
	
	@PostMapping("modify")
	public String modify(BoardDto board) {
		service.update(board);
		
		return "redirect:/board/list";
	}
	
	
	@PostMapping("remove")
	public String remove(int id, RedirectAttributes rttr) {
		int cnt = service.remove(id);
		
		// id번 게시물이 삭제되었습니다.
		if (cnt ==1) {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
		} else {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되지 않았습니다.");
		}
		// id번 게시물이 삭제되지 않았습니다.
		return "redirect:/board/list";
	}
}





