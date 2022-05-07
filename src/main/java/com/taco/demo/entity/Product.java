package com.taco.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String description;
	private double price;
	
	public Product() {}
	
	public Product(String code, String description, double price) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public String getCode() {
		return code;
	}
	
	void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
