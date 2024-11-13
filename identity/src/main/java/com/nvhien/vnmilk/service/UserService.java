package com.nvhien.vnmilk.service;

import com.nvhien.vnmilk.dto.request.UserCreateRequest;
import com.nvhien.vnmilk.dto.request.UserUpdateRequest;
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

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(String id, UserUpdateRequest request) {
        if (userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
}
