package com.nvhien.vnmilk.controller;

import com.nvhien.vnmilk.dto.request.UserCreateRequest;
import com.nvhien.vnmilk.dto.request.UserUpdateRequest;
import com.nvhien.vnmilk.dto.response.ApiResponse;
import com.nvhien.vnmilk.entity.User;
import com.nvhien.vnmilk.service.UserService;
import jakarta.validation.Valid;
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
    public ApiResponse<User> create(@RequestBody @Valid UserCreateRequest request) {
        User user = userService.create(request);
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setData(user);
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<User>> getAll() {
        List<User> users = userService.getAll();
        ApiResponse<List<User>> apiResponse = new ApiResponse<>();
        apiResponse.setData(users);
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") String id) {
        User user = userService.get(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") String id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
