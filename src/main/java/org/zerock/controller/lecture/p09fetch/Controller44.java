package org.zerock.controller.lecture.p09fetch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex44")
public class Controller44 {
	
	@RequestMapping("sub")
	public void method() {
		
	}
	
	@PostMapping("sub01")
	public void method01(String name, String address) {
		System.out.println("1번 메소드 일함");
		System.out.println(name);
		System.out.println(address);
	}
	
	
}


