
	package com.niit.shoppingcart.test;

	import static org.junit.Assert.*;

	import org.junit.Before;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	import com.niit.shoppingcart.dao.CategoryDAO;
	import com.niit.shoppingcart.model.Category;




	public class TestCategoryDAO {

		@Autowired
		CategoryDAO categoryDAO;

		

		
		@Autowired
		Category category;
		
		AnnotationConfigApplicationContext context;
		

		@Before
		public void init() {

			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
			category=(Category) context.getBean("category");
			
		}

		@Test
		public void CategoryTestCase() {
			int size = categoryDAO.list().size();
			assertEquals("category list test case ",2 , size);

		}

	}

