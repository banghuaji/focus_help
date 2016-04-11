package com.help.test.mySpring;

import org.springframework.stereotype.Repository;

@Repository
public class Middlemain {

	public void gethelloword(){
		System.out.println(this.getClass().getName());
	}
}
