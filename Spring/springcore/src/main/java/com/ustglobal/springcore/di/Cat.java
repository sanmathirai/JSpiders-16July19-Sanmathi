package com.ustglobal.springcore.di;

import org.springframework.stereotype.Component;

@Component("cat")//i we dont what beans to be created in xml
public class Cat implements Animal{

	@Override
	public void makeSound() {
		System.out.println("Miawwoo");

	}

}
