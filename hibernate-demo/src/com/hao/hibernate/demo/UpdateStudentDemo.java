package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentID = 2;
			
			// start a new session and new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(">> Retrieved student with ID: " + studentID);
			
			Student myStudent = session.get(Student.class, studentID);
			System.out.println(">> Updating...");
			
			session.delete(myStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
			
			
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

}
