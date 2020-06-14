package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;
import com.hao.hibernate.demo.entity.Student;

public class CreateDemo {

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
			// create the objects
			Instructor instructor = new Instructor("Donald", "Fergusen", "dff9@columbia.edu");
			InstructorDetail instructorDetail = new InstructorDetail("NO CHANNEL", "Baseball");
			
			Instructor instructor2 = new Instructor("Kenneth", "Ross", "kar@cs.columbia.edu");
			InstructorDetail instructorDetail2 = new InstructorDetail("NO CHANNEL", "Cigar");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			instructor2.setInstructorDetail(instructorDetail2);
			
			// start a transaction
			session.beginTransaction();
			
			// save
			// this also saves the instructor detail cuz of cascade
			session.save(instructor);
			session.save(instructor2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

}
