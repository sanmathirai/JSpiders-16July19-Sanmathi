package com.ustglobal.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ustglobal.springcore.config.importannotation.HelloConfigurationClass;
import com.ustglobal.springcore.di.Hello;
import com.ustglobal.springcore.di.Pet;

public class AnnotationImport {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfigurationClass.class);
		Hello hello = context.getBean(Hello.class);
		System.out.println(hello.getMsg());
		
		Hello hello1 = context.getBean(Hello.class);
		System.out.println(hello);
		System.out.println(hello1);
		System.out.println("*****************");
		
			/*
			 * Animal animal = context.getBean(Animal.class); animal.makeSound();
			 */
		System.out.println("*****Import**************");
		
		Pet pet = context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		
		context.close();
		
	}
		
}
