package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.User;

public interface IUserManager {

    int getUserId();
    User findUser(String username);
    String findPassword(String username);
    User findUserByEmail(String email);
    void userRegistration(User user);
    void logout();
}
