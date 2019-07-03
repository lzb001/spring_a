package com.jk.service;

import com.jk.dao.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("find/{name}")
    public String find(@PathVariable(value = "name") String name) {
        return name+"成功";
    }

    @PostMapping("findAll")
    public List<User> findAll(@RequestBody User user){
        return userMapper.userList(user);
    }

    @GetMapping("count")
    public long count(){
        return userMapper.count();
    }

    @GetMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @PostMapping("addUser")
    public void addUser(@RequestBody User user) {
        if (user.getUid()!=null){
            userMapper.updateByPrimaryKeySelective(user);
        }else {
            userMapper.insertSelective(user);
        }
    }
    @GetMapping("queryById/{id}")
    public User queryById(@PathVariable(value = "id") Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
