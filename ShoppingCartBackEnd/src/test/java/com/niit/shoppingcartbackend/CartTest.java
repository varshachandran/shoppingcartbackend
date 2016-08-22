package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;

public class CartTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		Cart cart=(Cart) context.getBean("cart");
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		

		
		cart.setId("CART01");
		cart.setPrice(1000);
		cart.setQuantity(1);
		cart.setTotal(1000);
		cart.setStatus('n');
        cart.setUser(userDAO.get("abcd"));
        cart.setProduct(productDAO.get("PR02"));
		cartDAO.saveOrUpdate(cart);

		System.out.println("updated");
	}

}
