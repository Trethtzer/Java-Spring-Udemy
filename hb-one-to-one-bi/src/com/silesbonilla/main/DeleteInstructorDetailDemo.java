package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;
import com.silesbonilla.beans.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			
			
			session.beginTransaction();
			
			int theId = 2;
			InstructorDetail tempID = session.get(InstructorDetail.class, theId);
			
			if (tempID != null) {
				System.out.println("tempInstructorDetail: " + tempID);
				System.out.println("tempInstructor: " + tempID.getTheInstructor());
			}
			
			// Delete the instructor detail
			
			tempID.getTheInstructor().setInstructorDetail(null);
			session.delete(tempID);
			
			session.getTransaction().commit();
			
			System.out.println("Pepito saved successfully");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}

}
