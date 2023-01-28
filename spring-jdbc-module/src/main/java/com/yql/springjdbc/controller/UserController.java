package com.yql.springjdbc.controller;

import com.yql.springjdbc.model.Users;
import com.yql.springjdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package com.yql.springjdbc.controller
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

    @GetMapping
    public List<Users> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Users get(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public Users post(@RequestBody Users users) {
        users.setId(userRepository.getNextId());
        return userRepository.save(users);
    }

    @PutMapping
    public Users put(@RequestBody Users users) {
        return userRepository.update(users);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.delete(id);
    }
}
