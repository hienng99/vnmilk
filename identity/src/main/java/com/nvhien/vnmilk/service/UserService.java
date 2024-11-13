package com.nvhien.vnmilk.service;

import com.nvhien.vnmilk.dto.request.UserCreateRequest;
import com.nvhien.vnmilk.entity.User;
import com.nvhien.vnmilk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserCreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
