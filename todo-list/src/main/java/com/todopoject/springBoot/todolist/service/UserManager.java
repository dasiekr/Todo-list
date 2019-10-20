package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.User;

public interface UserManager {

    int getUserId();
    User findUser(String username);
    String findPassword(String username);
    void userRegistration(User user);
    void logout();
}
