package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			
			// crfeate a student object
			Student st = new Student("Pepito", "Diaz", "pepediaz@hotmail.com");
			
			// start the transaction
			session.beginTransaction();
			
			//save the student object
			session.save(st);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Pepito saved successfully");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}

}
