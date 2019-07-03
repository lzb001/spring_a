package com.jk.service;

import com.jk.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "service-hi",fallback  = UserError.class)
public interface UserService {
    @GetMapping("find/{name}")
    String find(@PathVariable(value = "name") String name);
    @PostMapping("findAll")
    List<User> findAll(@RequestBody User user);
    @GetMapping("count")
    long count();
    @GetMapping("deleteUser/{id}")
    void deleteUser(@PathVariable(value = "id") Integer id);
    @PostMapping("addUser")
    void addUser(@RequestBody User user);
    @GetMapping("queryById/{id}")
    User queryById(@PathVariable(value = "id") Integer id);
}
