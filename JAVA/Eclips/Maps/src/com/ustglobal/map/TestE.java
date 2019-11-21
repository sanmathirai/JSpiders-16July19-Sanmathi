package com.ustglobal.map;


import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TestE {
	public static void main(String[] args) {

		TreeMap<String, Integer> lh = new TreeMap<String, Integer>();

		//cannot add other than generics like treeset
		lh.put("Mangalore", 574144);
		lh.put("Bangalore", 574144);
		lh.put("Patna", 125656);
		lh.put("Bangalore", 564144);
		//	lh.put(null,455); no null 

		System.out.println(lh);

		for(Map.Entry<String, Integer> entry : lh.entrySet()) {
			String key = entry.getKey();
			Integer value =entry.getValue();
			System.out.println("Key is :"+key +" \nValue is :"+value+"\n\n");
		}
	}
}
