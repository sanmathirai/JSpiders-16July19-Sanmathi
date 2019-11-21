package com.ustglobal.streams.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestB {
	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(4);
		al.add(12);
		al.add(41);

		List<Integer> l =al.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
		for(Integer s : l)
		{
			System.out.println(s);
		}
		List<Integer> l1 =al.stream().map(i -> i * i ).collect(Collectors.toList());
		for(Integer s : l1)
		{
			System.out.println(s);
		}
	}
}
