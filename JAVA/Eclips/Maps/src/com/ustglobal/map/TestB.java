package com.ustglobal.map;

import java.util.HashMap;

public class TestB {

	public static void main(String[] args) {
		HashMap hm = new HashMap();

		hm.put("Kuku", 456545);
		hm.put("Mala", 4545);
		hm.put("sheela", 556545);
		hm.put("Meena", 656545);

		HashMap hm1 = new HashMap();

		hm1.put("Shalini", 756545);
		hm1.put("Sonal", 8545);
		hm1.put("Manisha", 9556545);
		hm1.put("Deethi", 1656545);

		System.out.println("Hasmap 1 :"+hm);
		System.out.println("Hasmap 2 :"+hm1);
		
		boolean hasKey = hm.containsKey("Mala");
		System.out.println("\nHas key containsKey(Mala):"+hasKey);

		boolean hasValue  = hm.containsValue(4545);
		System.out.println("\nHas Value containsValue(4545):"+hasValue);
		
		hm.putAll(hm1);
		System.out.println("\nAfter put all :"+hm);
		
		
		System.out.println("\nSize of hashmap1 :"+hm.size());
		
		boolean empty  = hm.isEmpty();
		System.out.println("\nis empty map1 :"+empty);
		
		hm.clear();
		System.out.println("\nAfter Clear :"+hm);

	}
}
