package com.ustglobal.java8features.consumer;

import java.util.function.Consumer;

public class TestA {
	public static void main(String[] args) {

		Consumer<Student> c = s ->{
			System.out.println("name is"+ s.id);
			System.out.println("id is "+ s.name);
			System.out.println("Percentage"+ s.percentage);
		};
		Student s =new Student(1, "Sanmathi", 205.5);
		c.accept(s);
	}
}
