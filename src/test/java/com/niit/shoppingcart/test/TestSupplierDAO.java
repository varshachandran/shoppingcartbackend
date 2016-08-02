package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class TestSupplierDAO {

	@Autowired
	SupplierDAO supplierDAO;
	
	
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=  (SupplierDAO) context.getBean("supplierDAO");
		supplier=  (Supplier) context.getBean("supplier");
	}
	@Test
	public void SupplierTestCase()
	{
	 int size= supplierDAO.list().size();
	 assertEquals("Supplier list test case",1, size);
	}
	
	
}
