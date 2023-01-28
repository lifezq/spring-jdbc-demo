package com.yql.springdatajdbc.controller;

import com.yql.springdatajdbc.model.Users;
import com.yql.springdatajdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * @Package com.yql.springdatajdbc.controller
 * @ClassName UserController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/28
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Users get(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Users post(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @PutMapping
    public Users put(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    public Iterator<Users> list() {
        return userRepository.findAll().iterator();
    }
}
