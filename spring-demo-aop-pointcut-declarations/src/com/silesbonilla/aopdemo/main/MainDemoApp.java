package com.silesbonilla.aopdemo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.silesbonilla.aopdemo.DemoConfig;
import com.silesbonilla.aopdemo.dao.AccountDAO;
import com.silesbonilla.aopdemo.dao.MembershipDAO;
import com.silesbonilla.aopdemo.entity.Account;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		accountDAO.setName("Jorge");
		accountDAO.setServiceCode("591JHDF");
		
		Account account = new Account();
		
		accountDAO.addAccount(account);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		System.out.println(membershipDAO.addAccount());
		
		context.close();

	}

}
