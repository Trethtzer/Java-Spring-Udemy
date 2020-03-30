package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;

public class FetchJoinDemo {

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

			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courseList where i.id =:theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", 1);
			
			Instructor theInstructor = query.getSingleResult();
			
			System.out.println("The instructorrrr: " + theInstructor.toString());			
			
			session.getTransaction().commit();
			session.close();
			
			for(Course c : theInstructor.getCourseList()) {
				System.out.println("Course: " + c.toString());
			}			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			sf.close();
		}
	}

}
