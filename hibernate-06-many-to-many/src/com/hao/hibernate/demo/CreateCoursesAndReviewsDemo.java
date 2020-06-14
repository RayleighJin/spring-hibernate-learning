package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Course;
import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;
import com.hao.hibernate.demo.entity.Review;
import com.hao.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			Course course = new Course("Analysis of Algorithms");
			course.addReview(new Review("The most valuable course I have ever taken!"));
			course.addReview(new Review("I don't quite like it."));
			course.addReview(new Review("Hmmm...so so..."));
			
			System.out.println(">> Course reviews: " + course.getReviews());
			session.save(course);
			
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
