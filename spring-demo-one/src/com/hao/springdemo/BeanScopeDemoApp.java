package com.hao.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load configuration file
			ClassPathXmlApplicationContext context = 
					new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		// retrieve bean from spring container
			Coach theCoach = context.getBean("myCoach", Coach.class);
			Coach alphaCoach = context.getBean("myCoach", Coach.class);
			
		// check if they are the same
			boolean result = (theCoach == alphaCoach);
			
		// print the result
			System.out.println(result);
			
			
		// close the context
			context.close();
	}

}
