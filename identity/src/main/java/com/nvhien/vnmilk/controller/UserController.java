package com.nvhien.vnmilk.controller;

import com.nvhien.vnmilk.dto.request.UserCreateRequest;
import com.nvhien.vnmilk.dto.request.UserUpdateRequest;
import com.nvhien.vnmilk.dto.response.ApiResponse;
import com.nvhien.vnmilk.dto.response.UserResponse;
import com.nvhien.vnmilk.entity.User;
import com.nvhien.vnmilk.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

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
    public UserResponse get(@PathVariable("id") String id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable("id") String id, @RequestBody UserUpdateRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
