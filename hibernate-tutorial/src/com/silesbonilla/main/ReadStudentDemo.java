package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			
			// create a student object
			Student st = new Student("Antonio", "Villalba", "competiciones.villalba@hotmail.com");			
			// start the transaction
			session.beginTransaction();			
			//save the student object
			session.save(st);			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("The student id: " + st.getId());
			session = sf.getCurrentSession();
			session.beginTransaction();
			Student newSt = session.get(Student.class,st.getId());
			System.out.println("The student: " + newSt);
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}

}
