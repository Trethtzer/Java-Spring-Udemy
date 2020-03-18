package com.silesbonilla.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {						
			// start the transaction
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student s where s.email LIKE '%hotmail.com' or s.lastName= 'Bonilla'").getResultList();	
			
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		// display students
		for (Student s : theStudents) {
			System.out.println("Student " + s.getFirstName() + " " + s.getLastName() + "\nEmail: " + s.getEmail());
		}
	}

}
