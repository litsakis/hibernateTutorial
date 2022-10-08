package com.luv2code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
	//create session

		Session session = factory.getCurrentSession();
		
		try {
			
		
			
			//use the session object to save java object
		
			//start a transaction
			session.beginTransaction();
			
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			for (Student tempStudent : theStudents) {
				
				System.out.println(tempStudent);
			}
			
			
			List<Student> litsakisStudents = session.createQuery("from Student s where s.lastName like 'pentakis'").getResultList();
			
			//display students
			for (Student tempStudent : litsakisStudents) {
				
				System.out.println(tempStudent);
			}
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
	}

}
