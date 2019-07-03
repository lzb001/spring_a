package com.jk.service;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("find/{name}")
    public String find(@PathVariable(value = "name") String name){
        return userService.find(name);
    }

    @PostMapping("findAll")
    public Map<String,Object> findAll(User user){
        List<User> list =  userService.findAll(user);
        long count = userService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @GetMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id){
        userService.deleteUser(id);
    }

    @PostMapping("addUser")
    public void addUser(User user){
        userService.addUser(user);
    }


}
