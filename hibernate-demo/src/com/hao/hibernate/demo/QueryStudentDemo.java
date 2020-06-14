package com.hao.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hao.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
				
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query a student
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName='Choi' or s.firstName='Pat'").getResultList();
			System.out.println("Students with last name of Choi or first name of Pat: ");
			displayStudents(students);
			
			
			students = session.createQuery("from Student s where s.email like '%barnard.edu'").getResultList();
			System.out.println("Students who have barnard email:");
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("All job done.");
			
		}
		catch (Exception e) {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
