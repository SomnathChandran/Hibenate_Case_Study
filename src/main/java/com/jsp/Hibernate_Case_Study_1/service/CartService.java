package com.jsp.Hibernate_Case_Study_1.service;

import java.util.List;

import com.jsp.Hibernate_Case_Study_1.dao.CartDao;
import com.jsp.Hibernate_Case_Study_1.entity.Cart;

public class CartService {

    private CartDao cartDao;

    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void saveCart(Cart cart) {
        cartDao.saveCart(cart);
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    public void deleteCart(Cart cart) {
        cartDao.deleteCart(cart);
    }

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public List<Cart> getAllCarts() {
        return cartDao.getAllCarts();
    }
}




