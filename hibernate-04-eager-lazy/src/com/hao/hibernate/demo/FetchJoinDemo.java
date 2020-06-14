package com.hao.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hao.hibernate.demo.entity.Course;
import com.hao.hibernate.demo.entity.Instructor;
import com.hao.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "join fetch i.courses "
							+ "where i.id=:instructorId", 
							Instructor.class);
			
			query.setParameter("instructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println(">> Instructor: " + instructor);
			
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
