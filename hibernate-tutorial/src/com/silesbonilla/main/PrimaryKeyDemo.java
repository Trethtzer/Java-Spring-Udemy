package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			
			// crfeate a student object
			Student st1 = new Student("Guillermo", "Siles", "guille@hotmail.com");
			Student st2 = new Student("Fernando", "Bonilla", "fernandito@hotmail.com");
			Student st3 = new Student("Tito", "Diego", "eldiego@hotmail.com");
			// start the transaction
			session.beginTransaction();
			
			//save the student object
			session.save(st1);
			session.save(st2);
			session.save(st3);
			
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
