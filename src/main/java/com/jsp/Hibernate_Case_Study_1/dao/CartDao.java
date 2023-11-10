package com.jsp.Hibernate_Case_Study_1.dao;



//	static Scanner sc = new Scanner(System.in);
//	static Configuration con =  new Configuration().configure().addAnnotatedClass(Cart.class);
//	static SessionFactory sf = con.buildSessionFactory();



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jsp.Hibernate_Case_Study_1.entity.Cart;

import java.util.List;

public class CartDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveCart(Cart cart) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        transaction.commit();
        session.close();
    }

    public void updateCart(Cart cart) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
    }

    public void deleteCart(Cart cart) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cart);
        transaction.commit();
        session.close();
    }

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.openSession();
        Cart cart = session.get(Cart.class, cartId);
        session.close();
        return cart;
    }

    public List<Cart> getAllCarts() {
        Session session = sessionFactory.openSession();
        Query<Cart> query = session.createQuery("FROM Cart", Cart.class);
        List<Cart> carts = query.list();
        session.close();
        return carts;
    }
}

