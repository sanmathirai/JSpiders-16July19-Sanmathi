package com.ustglobal.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TestG {
	public static void main(String[] args) {

		Employee s1 = new Employee(21, "Megha", 1145.5);
		Employee s2 = new Employee(12, "Sanmathi", 11145.5);
		Employee s3 = new Employee(33, "Navya", 2545.5);
		Employee s4 = new Employee(14, "Veekshitha", 6595.5);
		Employee s5 = new Employee(59, "Madhura", 96545.5);
		Employee s6 = new Employee(6,  "Rashmi", 65845.5);
		Employee s7 = new Employee(57, "Rashmi", 78945.5);
		Employee s8 = new Employee(8,  "Shyamala", 6445.5);
		Employee s9 = new Employee(19, "Ramya", 5545.5);

		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(s1);
		al.add(s2);
		al.add(s3);

		ArrayList<Employee> al1 = new ArrayList<Employee>();
		al1.add(s4);
		al1.add(s5);
		al1.add(s6);

		ArrayList<Employee> al2 = new ArrayList<Employee>();
		al2.add(s7);
		al2.add(s8);
		al2.add(s9);

		HashMap<String, ArrayList<Employee>> hm = new HashMap<>();

		hm.put("First", al);
		hm.put("Second", al1);
		hm.put("Third", al2);
		System.out.println(hm);


		ArrayList<Employee> first= hm.get("First");

		System.out.println("\n===First Manager details==");
		Iterator<Employee> it = first.iterator();
		while(it.hasNext()) {
			Employee s = it.next();
			System.out.println("Employee id     :"+s.id);
			System.out.println("Employee name   :"+s.name);
			System.out.println("Employee Salary :"+s.salary+"\n");
		}

		ArrayList<Employee> second= hm.get("Second");

		System.out.println("\n===Second Employee details==");
		Iterator<Employee> it1 = second.iterator();
		while(it1.hasNext()) {
			Employee s = it1.next();
			System.out.println("Employee id     :"+s.id);
			System.out.println("Employee name   :"+s.name);
			System.out.println("Employee Salary :"+s.salary+"\n");


		}

		ArrayList<Employee> third= hm.get("Third");
		System.out.println("\n===Third Employee details==");
		Iterator<Employee> it2 = third.iterator();
		while(it2.hasNext()) {
			Employee s = it2.next();
			System.out.println("Employee id     :"+s.id);
			System.out.println("Employee name   :"+s.name);
			System.out.println("Employee Salary :"+s.salary+"\n");


		}
	}
}
