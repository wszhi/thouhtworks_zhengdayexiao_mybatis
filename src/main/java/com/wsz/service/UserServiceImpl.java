package com.wsz.service;

import com.wsz.dao.UserDao;
import com.wsz.entity.User;

/**
 * Created by Administrator on 2016/2/27.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User selectUser(String name, String psw) {
        return userDao.selectUser(name,psw);
    }

    @Override
    public User getUser(String userid) {
        return userDao.getUser(userid);
    }

}
