package com.niit.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.*;

public class TestCaseUserDetails {
	@Autowired
	static UserDetailsDAO userdetailsDAO;

	@Autowired
	static User user;


	static AnnotationConfigApplicationContext context;
	
	UserDetails userdetails;


	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		user = (User) context.getBean("user");
	}

	@Test

	public void userNameTest() {
		userdetails = userdetailsDAO.get("dfer");
		String name = userdetails.getId();
		assertEquals("User Id Test", "dfer", name);

	}

}