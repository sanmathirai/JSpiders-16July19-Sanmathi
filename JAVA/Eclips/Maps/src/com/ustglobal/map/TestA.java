package com.ustglobal.map;

import java.util.HashMap;

public class TestA {
	
	public static void main(String[] args) {
		
		HashMap hm = new HashMap();
		
		
		hm.put("Kuku", 456545);
		hm.put("Mala", 4545);
		hm.put("sheela", 556545);
		hm.put("Meena", 656545);

		System.out.println("\n---Data of hashmap is :---\n"+hm);//toString is overriden
		hm.put("Kuku", 787);
		System.out.println("\n----data After adding *** DUPLICATE KEY ***:---\n"+hm);
		
		hm.put("Sanmathi", 656545);
		System.out.println("\n---data After adding  *** DUPLICATE VALUE ***:--\n"+hm);
		
		
		hm.put(null, 787);
		System.out.println("\n---data After adding  *** NULL KEY *** :--\n"+hm);
		
		hm.put(null, 687);
		System.out.println("\n---data After adding  *** DUPLICATE NULL KEY ***  :--\n"+hm);
		
		Object name = hm.get("sheela");
		System.out.println("\n---data After adding  *** Geeting Sheela ***  :--\n"+name);
		
		Object name1 = hm.get("maala");
		System.out.println("\n---data After adding  *** Geeting Maala which dosent exist ***  :--\n"+name1);
		
		Object name3 = hm.remove("sheela");
		System.out.println("\n---data After adding  *** Remove ***  :--\n"+name3);
		
		System.out.println("\n----data After Removing :---\n"+hm);
	}
}
