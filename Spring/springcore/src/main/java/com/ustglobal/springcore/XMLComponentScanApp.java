package com.ustglobal.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ustglobal.springcore.di.Animal;
import com.ustglobal.springcore.di.Cat;
import com.ustglobal.springcore.di.Hello;
import com.ustglobal.springcore.di.Pet;

public class XMLComponentScanApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Hello hello = context.getBean(Hello.class);
		hello.setMsg("Hi how are you");
		System.out.println(hello.getMsg());

		Hello hello2 = context.getBean(Hello.class);

		Pet pet = context.getBean(Pet.class);
		pet.setName("Ruby");
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
	}
}
