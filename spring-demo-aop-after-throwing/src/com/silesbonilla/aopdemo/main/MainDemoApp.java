package com.silesbonilla.aopdemo.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.silesbonilla.aopdemo.DemoConfig;
import com.silesbonilla.aopdemo.dao.AccountDAO;
import com.silesbonilla.aopdemo.entity.Account;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		try {
			boolean tripWare = true;
			List<Account> theAccounts = accountDAO.findAccounts(tripWare);
			System.out.println("Accounts found");
			System.out.println(theAccounts.toString());
		}catch(Exception e) {
			System.out.println("Main program caught an exception: " + e.toString());
		}
				
		
		
		context.close();

	}

}
