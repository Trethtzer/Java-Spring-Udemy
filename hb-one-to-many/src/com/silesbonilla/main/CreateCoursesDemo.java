package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;
import com.silesbonilla.beans.Student;

public class CreateCoursesDemo {

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
			
			Course c1 = new Course("Baduk series 1");
			Course c2 = new Course("Baduk series 2");
			Course c3 = new Course("Fundamentals of Go");
			Course c4 = new Course("Games of Shusaku");
			
			theInstructor.addCourse(c1);
			theInstructor.addCourse(c2);
			theInstructor.addCourse(c3);
			theInstructor.addCourse(c4);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);			
			
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
