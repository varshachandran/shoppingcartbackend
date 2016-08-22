package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {
	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}

	@Test

	public void ProductNameTest() {
		product = productDAO.get("PR02");
		String name = product.getName();
		System.out.println(name);
		assertEquals("Product Name Test", "ASUS", name);

	}
}
