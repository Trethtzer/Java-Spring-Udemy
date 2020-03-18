package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {	
			
			session.beginTransaction();
			
			int id = 2;
			Student st = session.get(Student.class, id);
			session.delete(st);
			
			session.createQuery("delete from Student where id = 3").executeUpdate();
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}

}
