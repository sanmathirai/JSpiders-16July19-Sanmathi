package com.ustglobal.java8features;

import java.util.ArrayList;

public class TestC {
	public static void main(String[] args) {
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(5, "SAnmathi",36.5));
		al.add(new Student(6, "Ramya", 26.5));
		al.add(new Student(7, "Sahil", 45.5));
		al.add(new Student(9, "Mahil", 16.5));
		al.add(new Student(10, "Dhoni", 62.5));
		
		Helper h = new Helper();
		h.displayAllStudents(al);
		h.displayFailedStudents(al);
		h.displayPassesStudents(al);
		

	}
}
