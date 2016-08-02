package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
        
		userDetails.setId("dfer");
		userDetails.setName("varsha");
		userDetails.setMobile("9544125911");
		userDetails.setMail("varshachandranck@gmail.com");
		userDetails.setAddress("challyl");
		userDetailsDAO.saveOrUpdate(userDetails);
		System.out.println("NO of users:"+userDetailsDAO.list().size());

		

		if(userDetailsDAO.get("USR002")== null)
		{
			System.out.println("User does not exist");
		}
		else
		{
			System.out.println("User exists..");
			System.out.println();
		} 
		
	}
} 