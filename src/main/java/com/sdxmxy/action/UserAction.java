package com.sdxmxy.action;

import com.sdxmxy.domain.User;
import com.sdxmxy.service.UserService;
import com.sdxmxy.service.impl.UserServiceImpl;
import com.sdxmxy.util.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserAction extends BaseAction<User> {

    private List<User> list;

    private UserService userService;

    public String list() {
        list = userService.findall();
        return "listJsp";
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
