package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Course;
import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;
import com.hao.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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
			// create the objects
			Instructor instructor = new Instructor("Xiaodong", "Pi", "xdpi@zju.edu.cn");
			InstructorDetail instructorDetail = new InstructorDetail("NO CHANNEL", "Drinking");
			
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save
			// this also saves the instructor detail cuz of cascade
			session.save(instructor);
			
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
