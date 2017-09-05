package com.yxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yxd
 * 测试项目是否搭建成功
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
