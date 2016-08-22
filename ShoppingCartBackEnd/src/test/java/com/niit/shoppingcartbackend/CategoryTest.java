package com.niit.shoppingcartbackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
public class CategoryTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		
		
		category.setId("ASD4");
		category.setName("CHJ2");
		category.setDescription("HSDE");
	    categoryDAO.saveOrUpdate(category);
		
	  
		
	    
	    if(categoryDAO.get("ASD2")== null)
		{
			System.out.println("Category does not exist");
		}
		else
		{
			System.out.println("Category exists..");
			System.out.println();
		} 
	}

}
