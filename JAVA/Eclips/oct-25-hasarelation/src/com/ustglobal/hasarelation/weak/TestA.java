package com.ustglobal.hasarelation.weak;

public class TestA {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		p.sleep();
		p.eat();
		System.out.println("**************");
		
		p.m.write(); // Has -A relation
		System.out.println(p.m.color);
	}
}
