package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
	//create session

		Session session = factory.getCurrentSession();
		
		try {
			
		
			
			//use the session object to save java object
			
			System.out.println("Creating new student object");
			//create a student object
			Student tempStudent = new Student("katerina","pentakis","katerinalitsakis@outlook.com");
			
			
			//start a transaction
			session.beginTransaction();
			//save student object
			session.save(tempStudent);
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			System.out.println("Saved student. Gen id: "+ tempStudent.getId());
			
			
			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("Getting student with id " + tempStudent.getId() );
			Student myStudent =session.get(Student.class, tempStudent.getId());
			System.out.println("get complete: " + myStudent);
			// commit the transaction
			
			
			session.getTransaction().commit();

			
		}
		finally {
			factory.close();
			
		}
	}

}
