package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;
import com.silesbonilla.beans.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			
			// crfeate a student object
			Instructor tempInstructor = new Instructor("Cristina", "Alberca", "suspensosadomicilo@patucasa.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://algoalgo.com","guitar");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start the transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempInstructor);
			
			// commit transaction
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
