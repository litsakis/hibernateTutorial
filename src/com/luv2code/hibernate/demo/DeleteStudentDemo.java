package com.luv2code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
	//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
	//create session

		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
		
			int studentId = 1;
			//use the session object to save java object
			Student tempStudent = session.get(Student.class, studentId);
		
			
		
			//save student object
			session.delete(tempStudent);
			System.out.println("delete the student");
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			 session = factory.getCurrentSession();

			session.beginTransaction();

			
		 session.createQuery("delete Student s where s.lastName='pentakis'").executeUpdate();
			
			
			//commit transaction

			session.getTransaction().commit();
		
		}
		finally {
			factory.close();
			
		}
	}

}
