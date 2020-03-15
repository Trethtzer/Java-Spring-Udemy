package com.silesbonilla.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.silesbonilla.springdemo.beans.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initbinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);		
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Customer theCustomer = new Customer();
		
		// add student object to the model
		theModel.addAttribute("customer",  theCustomer);
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer
							  , BindingResult theBindingResult) {
		
		System.out.println("Customer's first name" + theCustomer.getFirstName());
		System.out.println("Customer's second name" + theCustomer.getLastName());
		System.out.println("Customer's passes: " + theCustomer.getFreePass());
		
		System.out.println("\n\n");
		System.out.println("Binding result: " + theBindingResult);
		System.out.println("\n\n");
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";
		}
	}

}
