package com.sdxmxy.service.impl;

import com.sdxmxy.dao.UserDao;
import com.sdxmxy.dao.impl.UserDaoImpl;
import com.sdxmxy.domain.User;
import com.sdxmxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User getUserById(String id) {
        return userDao.findById(Integer.getInteger(id));
    }

    @Override
    public List<User> findall() {
        return userDao.findAll();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
