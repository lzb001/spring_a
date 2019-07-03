package com.jk.service;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QueryController {

    @Autowired
    private UserService userService;

    @GetMapping("queryById/{id}")
    public String queryById(@PathVariable(value = "id") Integer id, Model model){
        User user = userService.queryById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    @RequestMapping("toindex")
    public String toindex(){
        return "index";
    }

    @RequestMapping("toaddUser")
    public String toaddUser(){
        return "addUser";
    }
}
