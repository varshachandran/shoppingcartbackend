package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		
		
	    product.setId("PR02");
		product.setName("ASUS");
		product.setDescription("Laptop");
		product.setPrice(50000);
		product.setCategory(categoryDAO.get(",IDN1"));
		product.setSupplier(supplierDAO.get(",SUP1"));
	    productDAO.saveOrUpdate(product);
		System.out.println("NO of products:"+productDAO.list().size());
	   
		
	    if(productDAO.get("PR02")== null)
		{
			System.out.println("Product does not exist");
		}
		else
		{
			System.out.println("Product exists..");
			System.out.println();
		} 
	}
}

