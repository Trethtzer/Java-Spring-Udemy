package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Course;
import com.silesbonilla.beans.Instructor;
import com.silesbonilla.beans.InstructorDetail;
import com.silesbonilla.beans.Review;
import com.silesbonilla.beans.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();

		try {			

			session.beginTransaction();

			Course tempCourse1 = new Course("Basic course to how to ride a bike");
			Course tempCourse2 = new Course("Basic course to how to ride a motorbike");
			Course tempCourse3 = new Course("Basic course to how to ride a car");
			
			System.out.println("Saving Course " + tempCourse1.toString());
			session.save(tempCourse1);
			System.out.println("Saving Course " + tempCourse2.toString());
			session.save(tempCourse2);
			System.out.println("Saving Course " + tempCourse3.toString());
			session.save(tempCourse3);
			
			
			Student tempStudent1 = new Student("John", "Doe", "john@yahoo.com");
			Student tempStudent2 = new Student("Cristian","Pop", "poppy@yahoo.com");
			Student tempStudent3 = new Student("Artemis", "Fowl", "kachanovsky@yahoo.com");
			
			System.out.println("Saving Student " + tempStudent1.toString());
			session.save(tempStudent1);
			System.out.println("Saving Student " + tempStudent2.toString());
			session.save(tempStudent2);
			System.out.println("Saving Student " + tempStudent3.toString());
			session.save(tempStudent3);
			
			tempCourse1.addStudent(tempStudent1);
			tempCourse1.addStudent(tempStudent2);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}

}
