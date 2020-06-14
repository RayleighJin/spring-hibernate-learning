package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Course;
import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;
import com.hao.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			Course course1 = new Course("Semiconductors");
			Course course2 = new Course("Intro to Photonics");
			
			instructor.add(course1);
			instructor.add(course2);
			
			// save
			// this also saves the instructor detail cuz of cascade
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
