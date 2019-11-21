package com.ustglobal.java8features.function;

import java.util.function.Function;

import com.ustglobal.java8features.Student;

public class TestB {
	public static void main(String[] args) {

		Function<Integer, Student> f= id -> {
			Student s = new Student(2,"sanmathi" ,563.5);
			s.id = id;
			return s;
		};
		Student s =f.apply(27);
		System.out.println("Id "+s.id);
		


	}
}
