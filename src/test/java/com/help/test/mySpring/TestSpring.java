package com.help.test.mySpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	  public static void main(String[] args) {
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/help/test/mySpring/*.xml");
	        UsingSpring book = (UsingSpring)context.getBean("myBook");
	        Middlemain mm = (Middlemain)context.getBean("middlemian");
	        System.out.println(book.getAuthor());
	        book.setAuthor("jbh");
	        System.out.println(book.toString());
	        mm.gethelloword();
	    }

}
