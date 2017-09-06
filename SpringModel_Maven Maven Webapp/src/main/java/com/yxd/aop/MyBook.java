package com.yxd.aop;

public class MyBook {
	public void before1() {
		System.out.println("Book中的read方法之前：log");
	}
	public void after1() {
		System.out.println("Book中的read方法之后：log");
	}
}
