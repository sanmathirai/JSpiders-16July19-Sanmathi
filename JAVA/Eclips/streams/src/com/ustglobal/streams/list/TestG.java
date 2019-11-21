package com.ustglobal.streams.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestG {
	public static void main(String[] args) {
		ArrayList<Employee> al= new ArrayList<Employee> ();
		Employee e1 = new Employee(1, "Sanmthi");
		Employee e2 = new Employee(2, "Megha");
		Employee e3 = new Employee(3, "Sai");
		
		al.add(e1);
		al.add(e2);
		al.add(e3);
		
		Comparator<Employee> com = (e4 , e6) ->
		{
			return e4.name.compareTo(e6.name);
		};
		
		List<Employee> e=al.stream().sorted(com).collect(Collectors.toList());

		Iterator<Employee> it = e.iterator();
		while(it.hasNext()) {
			Employee val =it.next();
			System.out.println("Val is"+ val);
		}
	}
}
