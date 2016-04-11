package com.help.test.mySpring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.help.test.mySpring.Middlemain;

@ContextConfiguration(locations = { "classpath:com/help/test/mySpring/servlet.xml" })
public class Mytetst  extends AbstractTestNGSpringContextTests{

	@Autowired
	private TestBean61 testBean61;

	@Autowired
	private Middlemain middlemain;

	@Autowired
	private MyDbConnection myDbConnection;

	/**
	 * @param args
	 */
	@Test
	public void Erew() {

//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/help/test/mySpring/*.xml");
//		MyDbConnection myDbConnection = ctx.getBean("MyDbConnection", MyDbConnection.class);
//		myDbConnection.delstudentbyname(127);

		 myDbConnection.delstudentbyname(134);
		 System.out.println("main");
		 testBean61.getjpa1();
		 testBean61.getjpa3();
		 testBean61.getjpa2();
		 middlemain.gethelloword();
	}

}
