package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex17")
public class Controller17 {

	@RequestMapping("sub01")
	public void method1(Model model) {
		model.addAttribute("myName", "cha bum");
	}
	
	// /ex17/sub02 요청
	// /WEB-INF/views/ex17/sub02.jsp 포워드
	// add attribute : email : abc@daum.net
	@RequestMapping("sub02")
	public void method2(Model model) {
		model.addAttribute("email", "abc@daum.net");
	}
	
	
}






