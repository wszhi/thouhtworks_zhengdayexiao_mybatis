package com.wsz.dao;

import com.wsz.entity.Cart;

import java.util.List;

/**
 * Created by Administrator on 2016/2/27.
 */
public interface CartDao {
    public List<Cart> getCartByUserid(String userid);
    public Cart getCartinfo(String userid,String bookid);
    public void delCart(String id);
    public void updateCart(Cart cart);
    public void insertCart(Cart cart);
}
