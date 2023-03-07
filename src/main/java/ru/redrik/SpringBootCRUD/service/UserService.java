package ru.redrik.SpringBootCRUD.service;

import ru.redrik.SpringBootCRUD.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User user);
    User showUser(Long id);
}
