package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
						
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// use the session to save the Java object
					
					// create 3 student objects
					System.out.println("Creating new student obj...");
					Student tempStudent1 = new Student("Henry", "Campus", "hc2848@barnard.edu");
					Student tempStudent2 = new Student("Finn", "Wallace", "fw2738@barnard.edu");
					Student tempStudent3 = new Student("Alissa", "Choi", "ac2133@barnard.edu");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("All job done.");
					
				}
				catch (Exception e) {
					factory.close();
				}

	}

}
