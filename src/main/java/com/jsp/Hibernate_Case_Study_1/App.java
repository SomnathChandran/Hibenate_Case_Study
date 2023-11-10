package com.jsp.Hibernate_Case_Study_1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.Hibernate_Case_Study_1.dao.ProductDao;
import com.jsp.Hibernate_Case_Study_1.entity.Product;
import com.jsp.Hibernate_Case_Study_1.service.ProductService;

public class App 
{
	public static void main( String[] args )
	{
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses= sf.openSession();
		
		System.out.println("There Are Two Services We Are Provided As Of Now \n 1.ProductServices \n 2.CartServices");
		
		System.out.println("Enter The Choice Of Service");
		
		int choice = sc.nextInt();
		
		if (choice == 1) {
			System.out.println(" 1.addProduct \n 2.getallProduct \n 3.getProductbyid \n 4.updateProduct \n 5.deleteProduct \n 0.terminate");
			
			System.out.println("Enter The Choice");
			int choice1=sc.nextInt();

			switch (choice1) {
			case 1:
				ProductService.addProduct();
				break;
			case 2:
				ProductService.getAllProducts();

				break;
			case 3:
				ProductService.getProductById();

				break;
			case 4:
				ProductService.updateProduct();

				break;
			case 5:
				ProductService.deleteProduct();

				break;

			default:
				break;
			}
			
		} else 
		{
			System.out.println(" 1.saveCart \n 2.updateCart \n 3.deleteCart \n 4.getCartById \n 5.getAllCarts ");

		}
		

	}
}