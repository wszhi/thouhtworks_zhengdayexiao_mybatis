package com.wsz.dao;

import com.wsz.entity.Cart;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class CartDaoImpl implements CartDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Override
    public List<Cart> getCartByUserid(String userid) {
        String hql = "from Cart c where c.userid=:userid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("userid", userid);
        return query.list();
    }

    @Override
    public Cart getCartinfo(String userid,String bookid) {
        String hql = "from Cart c where c.userid=:userid and c.bookid=:bookid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("userid", userid);
        query.setString("bookid", bookid);

        return (Cart)query.uniqueResult();
    }

    @Override
    public void delCart(String id) {
        String hql = "delete Cart c where c.id=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateCart(Cart cart) {
        String hql = "update Cart c set c.number=:number,c.allprice=:allprice where c.id=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("number", cart.getNumber());
        query.setDouble("allprice", cart.getNumber()*cart.getPrice());
        query.setString("id", cart.getId());

        query.executeUpdate();
    }

    @Override
    public void insertCart(Cart cart) {
        cart.setAllprice(cart.getNumber()*cart.getPrice());
        sessionFactory.getCurrentSession().save(cart);
    }
}
