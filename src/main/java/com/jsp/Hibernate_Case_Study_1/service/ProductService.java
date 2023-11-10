package com.jsp.Hibernate_Case_Study_1.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;

import com.jsp.Hibernate_Case_Study_1.dao.ProductDao;
import com.jsp.Hibernate_Case_Study_1.entity.Product;

public class ProductService {
	static Scanner sc = new Scanner(System.in);
	public static void addProduct(){       // SAVE => save()

		Product p = new Product();
		System.out.println("Enter the Product Id");
		p.setProductId(sc.nextInt());
		System.out.println("Enter the Product Name");
		p.setProductName(sc.next());
		System.out.println("Enter the Product Price");
		p.setProductPrice(sc.nextInt());
		System.out.println("Enter the Product Quantity");
		p.setProductQuantity(sc.nextInt());
		
		ProductDao.addProduct(p);
		System.out.println("Products Added Successfully");

	}
	public static void getProductById() {      // get()/find()/load() => we have to handle the exception for load
		System.out.println("Enter the Product ID to Get..");
		int value = sc.nextInt();
		Product product = ProductDao.getProductById(value);
		System.out.println(product);

	}
	public static void getAllProducts() {     // use HQL Query
		Product p = new Product();
		List<Product> product = ProductDao.getAllProducts();
		for (Product product2 : product) {
			System.out.println("["+product2.getProductId()+" , "+product2.getProductName()+" , "+product2.getProductPrice()
			+ " , "+ product2.getProductQuantity()+"]");
		}

	}
	public static void updateProduct() {      // update()
		//Product product = new Product();
		System.out.println("Enter The Product ID to Update the Products");
		int pid = sc.nextInt();
		Product product1=ProductDao.getProductById(pid);
		if(product1 != null) {
			System.out.println("Enter the data to be update \n"
					+ "choose :-\n"
					+ "1. To update productName \n "
					+ "2. To update productPrice \n"
					+ "3. To update productQuantity \n");
			int value = sc.nextInt();
			switch (value) {
			case 1:
				System.out.println("Enter the Name to Update The Product Name");
				String name = sc.next();
				product1.setProductName(name);
				break;
			case 2 : 
				System.out.println("Enter the Price to Update The Product Price");
				int price = sc.nextInt();
				product1.setProductPrice(price);

				break;
			case 3 : 
				System.out.println("Enter the Quantity to Update The Product Quantity");
				int quantity = sc.nextInt();
				product1.setProductQuantity(quantity);
				break;
			default:
				System.out.println("Enter Valid Details");
				break;

			}
			ProductDao.updateProduct(product1);
		}

		System.out.println("Successfully Updated the Data..!!");

	}
	public static void deleteProduct() {        // Delete()
		System.out.println("Enter the ProductID to Delete");
		int pid = sc.nextInt();
		Product product1=ProductDao.getProductById(pid);
		ProductDao.deleteProduct(product1);


	}



}
