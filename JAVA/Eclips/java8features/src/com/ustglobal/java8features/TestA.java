package com.ustglobal.java8features;

import java.util.function.Predicate;

public class TestA {
public static void main(String[] args) {
	
	Predicate<Integer> p = i-> {
		if(i%2 == 0)
			return true;
		else 
			return false;
		
	};
	
	 boolean result = p.test(5);
	 System.out.println("Result is :"+result);
}
}
