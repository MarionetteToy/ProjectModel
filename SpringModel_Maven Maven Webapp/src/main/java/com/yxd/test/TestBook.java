package com.yxd.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yxd.aop.Book;

public class TestBook {
	@Test
	public void testBook() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Book book = (Book) ac.getBean("book");
		System.out.println(book);
		book.read();
	}
}
