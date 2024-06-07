package com.example.prescription.models;

import com.example.prescription.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void deleteById(Long id);
}

