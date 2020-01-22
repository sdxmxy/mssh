package com.sdxmxy.dao;

import com.sdxmxy.domain.User;

import java.util.List;

public interface UserDao {

    int findCount();

    List<User> findByPage(int begin, int pageSize);

    void save(User user);

    User findById(int did);

    void update(User user);

    void delete(User user);

    List findAll();
}
