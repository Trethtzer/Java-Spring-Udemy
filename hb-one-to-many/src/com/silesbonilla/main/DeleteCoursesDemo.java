package com.silesbonilla.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;

public class DeleteCoursesDemo {

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
			
			List<Course> courseList = theInstructor.getCourseList();
			Course course = courseList.get(0);
//			courseList.remove(0);
//			theInstructor.setCourseList(courseList);
			
			session.delete(course);
								
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
