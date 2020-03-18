package com.silesbonilla.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.silesbonilla.beans.Employee;
import com.silesbonilla.beans.Student;

public class EmployeeDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.createQuery("delete from Employee").executeUpdate();
			
			Employee e = new Employee("Juan Antonio", "Sanchez", 0);
			session.save(e);
			
			session.getTransaction().commit();
			
			session = sf.getCurrentSession();
			session.beginTransaction();
			
			Employee e1 = new Employee("Papapa", "Sanchez", 0);
			session.save(e1);
			Employee e2 = new Employee("Juan", "Sanchez", e1.getId());
			session.save(e2);
			Employee e3 = new Employee("Ana", "Sanchez", e1.getId());
			session.save(e3);
			Employee e4 = new Employee("Mavi", "Siles", e2.getId());
			session.save(e4);
			
			
			// Update Juan 
			session.createQuery("update Employee set pm = 0 where idEmployee = " + e2.getId()).executeUpdate();
			
			session.delete(e);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sf.close();
		}
	}

}
