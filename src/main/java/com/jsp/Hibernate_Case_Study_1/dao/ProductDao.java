package com.jsp.Hibernate_Case_Study_1.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.Hibernate_Case_Study_1.entity.Cart;
import com.jsp.Hibernate_Case_Study_1.entity.Product;

public class ProductDao {

	static Scanner sc = new Scanner(System.in);

	static Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
	static SessionFactory sf = con.buildSessionFactory();



	public static void addProduct(Object obj){       // SAVE => save()
	     Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(obj);
		trans.commit();
		session.close();
	}
	public static Product getProductById(int id) { 
		Session session = sf.openSession();                    // get()/find()/load() => we have to handle the exception for load
		Transaction trans = session.beginTransaction();
		Product product = session.get(Product.class, id);
		// System.out.println(product);
		trans.commit();
		session.close();
		return product;

	}

	public static List<Product> getAllProducts() {     // use HQL Query
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		System.out.println("Your All Products List");
		Query<Product> query = session.createQuery("from Product",Product.class);
		List<Product> pList = query.getResultList();
		trans.commit();
		session.close();
		return pList;
	}

	public static void updateProduct(Object obj) {      // update()
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
			session.update(obj);	
			System.out.println("Update Successfully");
		trans.commit();
		session.close();
	}
	

	public static void deleteProduct(Object obj) {        // Delete()
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(obj);
		trans.commit();
		session.close();
	}
















}
