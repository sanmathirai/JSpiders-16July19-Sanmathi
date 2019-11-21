package com.ustglobal.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestD {
	public static void main(String[] args) {

		LinkedHashMap<String, Integer> lh = new LinkedHashMap<String, Integer>();

		lh.put("Mangalore", 574144);
		lh.put("Bangalore", 574144);
		lh.put("Patna", 125656);
		lh.put("Bangalore", 564144);

		for(Map.Entry<String, Integer> s :lh.entrySet()) {
			String  key  = s.getKey();
			Integer value = s.getValue();
			System.out.println("Key is :"+key +" \nValue is :"+value+"\n\n");
		}
	}
}
