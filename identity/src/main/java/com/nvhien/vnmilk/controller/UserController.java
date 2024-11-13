package com.nvhien.vnmilk.controller;

import com.nvhien.vnmilk.dto.request.UserCreateRequest;
import com.nvhien.vnmilk.entity.User;
import com.nvhien.vnmilk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserCreateRequest request) {
        User user = userService.create(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") String id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
}
