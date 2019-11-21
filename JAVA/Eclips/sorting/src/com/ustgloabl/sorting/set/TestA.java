package com.ustgloabl.sorting.set;

import java.util.HashSet;
import java.util.Iterator;



public class TestA {
public static void main(String[] args) {
	HashSet hs =  new HashSet();
	hs.add(12);
	hs.add(45);
	hs.add("deepa");
	hs.add(null);
	hs.add(null);
	hs.add(12);
	//No get method
	
	System.out.println("--Using for each---");
	for(Object o: hs) {
		System.out.println(o);
	}
	System.out.println("--Using Iterator---");
	Iterator it =hs.iterator();
	while(it.hasNext())
	{
		Object o = it.next();
		System.out.println(o);
	}
	
}
}
