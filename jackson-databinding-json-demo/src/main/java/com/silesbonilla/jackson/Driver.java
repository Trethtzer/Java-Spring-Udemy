package com.silesbonilla.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and convert to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print tostring to validate.
			System.out.println(theStudent.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
