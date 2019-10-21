package com.todopoject.springBoot.todolist.validator;

import com.todopoject.springBoot.todolist.error.DifferentPasswordException;
import com.todopoject.springBoot.todolist.error.ExistingEmailException;
import com.todopoject.springBoot.todolist.error.ExistingUsernameException;
import com.todopoject.springBoot.todolist.model.User;

public interface IUserValidator {

    void userValidation(User user) throws ExistingUsernameException, DifferentPasswordException, ExistingEmailException;
    void checkingUsername(User user) throws ExistingUsernameException;
    void checkingPassword(User user) throws DifferentPasswordException;
    void checkingEmail(User user) throws ExistingEmailException;
}
