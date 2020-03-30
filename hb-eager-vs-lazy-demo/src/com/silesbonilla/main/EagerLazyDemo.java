package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;
import com.silesbonilla.beans.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			

			session.beginTransaction();

			Instructor theInstructor = session.get(Instructor.class, 1);
			
			System.out.println("The instructorrrr: " + theInstructor.toString());			
			
			for(Course c : theInstructor.getCourseList()) {
				System.out.println("Course: " + c.toString());
			}			
			
			System.out.println("Pepito saved successfully");
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}

}
