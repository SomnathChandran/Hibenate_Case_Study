package com.jsp.Hibernate_Case_Study_1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	private int cartId;
	@OneToMany
	private List<Product>products;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}
	
	
}
