package com.wsz.service;

import com.wsz.entity.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> getCartByUserid(String userid);
    public Cart getCartinfo(String userid,String bookid);
    public void delCart(String id);
    public void updateCart(Cart cart);
    public void insertCart(Cart cart);
}
