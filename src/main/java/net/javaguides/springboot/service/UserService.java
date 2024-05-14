package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getUsers();
    User updateUserById(Long userId,User user);
    void deleteUserById(Long userId);
}
