package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Pat", "Ronaldo", "pr2194@barnard.edu");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println(">> Generated ID: " + tempStudent.getId());
			
			// start a new session and new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(">> Retrieved student with ID: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println(">> The student: " + myStudent);
			
			System.out.println("All job done.");
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

}
