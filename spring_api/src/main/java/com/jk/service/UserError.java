package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserError implements  UserService{
    public String find(String name) {
        return name+"网络错误";
    }

    public List<User> findAll(User user) {
        return null;
    }

    public List<User> findAll(Integer offset, Integer limit) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteUser(Integer id) {

    }

    public void addUser(User user) {

    }

    public User queryById(Integer id) {
        return null;
    }
}
