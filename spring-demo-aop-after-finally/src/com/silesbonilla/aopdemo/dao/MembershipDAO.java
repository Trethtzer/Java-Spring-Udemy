package com.silesbonilla.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

public String addAccount() {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
		return "Yep";
	}
}
