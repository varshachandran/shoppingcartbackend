package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		
		user.setAddress("trissur");
		user.setMail("niit@gmail.com");
		user.setMobile("954415862");
	    user.setId("id1");
	    user.setName("gfjg");
		user.setPassword("yhj");
		user.setIsadmin(false);
	    userDAO.saveOrUpdate(user);
		System.out.println("NO of users:"+userDAO.list().size());
	    

		  
	    
	    if(userDAO.get("ad")== null)
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
