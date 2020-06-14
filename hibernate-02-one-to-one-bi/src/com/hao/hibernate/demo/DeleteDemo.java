package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			int id = 2;
			Instructor instructor = session.get(Instructor.class, id);
			if (instructor!= null) {
				System.out.println(">> Deleting... " + instructor);
				session.delete(instructor);
			}
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

}
