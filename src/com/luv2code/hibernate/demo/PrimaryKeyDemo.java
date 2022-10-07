package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
	//create session

		Session session = factory.getCurrentSession();
		
		try {
			
		
			
			//use the session object to save java object
			
			System.out.println("Creating new student object");
			//create 3 students object
			Student tempStudent1 = new Student("Alexandros","litsakis","litsakis@outlook.com");
			Student tempStudent2= new Student("Lili","litsakis","lililitsakis@outlook.com");
			Student tempStudent3 = new Student("Rikos","litsakis","rikoslitsakis@outlook.com");
			
			
			//start a transaction
			session.beginTransaction();
			//save student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			
			System.out.println("Saving the student");
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
	}
}
