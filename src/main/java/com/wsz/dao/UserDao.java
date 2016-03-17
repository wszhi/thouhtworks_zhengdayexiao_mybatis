package com.wsz.dao;

import com.wsz.entity.User;

/**
 * Created by Administrator on 2016/2/27.
 */
public interface UserDao {
    public User selectUser(String name,String psw);
    public User getUser(String userid);
}
