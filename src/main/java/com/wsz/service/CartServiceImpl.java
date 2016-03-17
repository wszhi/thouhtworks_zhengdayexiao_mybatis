package com.wsz.service;

import com.wsz.dao.CartDao;
import com.wsz.dao.CartDaoImpl;
import com.wsz.entity.Cart;

import java.util.List;

/**
 * Created by Administrator on 2016/2/27.
 */
public class CartServiceImpl implements CartService {
    private CartDao cartDao;

    public CartDao getCartDao() {
        return cartDao;
    }

    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<Cart> getCartByUserid(String userid) {
        return cartDao.getCartByUserid(userid);
    }

    @Override
    public Cart getCartinfo(String userid,String bookid) {
        return cartDao.getCartinfo(userid,bookid);
    }

    @Override
    public void delCart(String id) {
        cartDao.delCart(id);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    @Override
    public void insertCart(Cart cart) {
        cartDao.insertCart(cart);
    }

}
