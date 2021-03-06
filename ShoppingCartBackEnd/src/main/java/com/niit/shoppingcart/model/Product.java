package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private int price;
	
//	@Transient
//	private MultipartFile image;
//	
//	public MultipartFile getImage(){
//		
//		return image;
//	}	
//	public void setImage(MultipartFile image){
//		this.image = image;
//		
//	}
	
//	public void setCategory_id(String category_id) {
//		this.category_id = category_id;
//	}
//	
//	public String getSupplier_id() {
//		return supplier_id;
//	}
//
//	public void setSupplier_id(String supplier_id) {
//		this.supplier_id = supplier_id;
//	}
//
//	private String category_id;
//	
//	private String supplier_id;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	


	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
