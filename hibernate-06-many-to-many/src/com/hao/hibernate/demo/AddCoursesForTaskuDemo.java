package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Course;
import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;
import com.hao.hibernate.demo.entity.Review;
import com.hao.hibernate.demo.entity.Student;

public class AddCoursesForTaskuDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			int id = 2;
			Student tasku = session.get(Student.class, id);
			Course phil = new Course("Ancient Philosophy");
			Course phy = new Course("Thermal Physics");
			
			phil.addStudent(tasku);
			phy.addStudent(tasku);
			
			session.save(phil);
			session.save(phy);
			
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
