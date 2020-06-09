package com.hao.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// retirve bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
//		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// do the work
//		boolean result = (theCoach == alphaCoach);
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();
	}

}
