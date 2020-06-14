package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			
			// create a student object
			System.out.println("Creating new student obj...");
			Student tempStudent = new Student("Naomi", "Westbrook", "nw2020@barnard.edu");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

}
