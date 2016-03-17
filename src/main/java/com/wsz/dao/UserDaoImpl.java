package com.wsz.dao;

import com.wsz.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 * Created by Administrator on 2016/2/27.
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Override
    public User selectUser(String name, String psw) {
        String hql = "from User u where u.name=? and u.psw=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, name);
        query.setString(1, psw);
        return (User)query.uniqueResult();
    }

    @Override
    public User getUser(String userid) {
        String hql = "from User u where u.name=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, userid);
        return (User)query.uniqueResult();
    }
}
