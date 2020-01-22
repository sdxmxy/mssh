package com.sdxmxy.service;

import com.sdxmxy.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(String id);

    List<User> findall();
}
