package com.yxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yxd
 * ������Ŀ�Ƿ��ɹ�
 *
 */
@Controller
public class TestController {
	
	@RequestMapping("/testController.do")
	public String testController(String username) {
		System.out.println("--------------------------------------");
		System.out.println(username);
		System.out.println("--------------------------------------");
		if("admin".equalsIgnoreCase(username)) {
			return "success";
		} else {
			return "failed";
		}

	}
}
