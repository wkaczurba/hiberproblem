package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HiberproblemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HiberproblemApplication.class, args);
		
		Problem problem = context.getBean(Problem.class);
		
		problem.problem();
		problem.read();
		
		// TODO: Try removing array list etc from private constructors.!
		
	}
}
