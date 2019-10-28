package com.todopoject.springBoot.todolist.validator;

import com.todopoject.springBoot.todolist.error.DifferentPasswordException;
import com.todopoject.springBoot.todolist.error.ExistingEmailException;
import com.todopoject.springBoot.todolist.error.ExistingUsernameException;
import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator {

    @Autowired
    UserManager userManager;


    @Override
    public void userValidation(User user) throws ExistingUsernameException, DifferentPasswordException, ExistingEmailException {
        checkingUsername(user);
        checkingPassword(user);
        checkingEmail(user);
    }

    @Override
    public void checkingUsername(User user) throws ExistingUsernameException {
        String username = user.getUsername();

        if(userManager.findUser(username) != null)
            throw new ExistingUsernameException();
    }

    @Override
    public void checkingPassword(User user) throws DifferentPasswordException {
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if(!password.equals(confirmPassword))
            throw new DifferentPasswordException();
    }

    @Override
    public void checkingEmail(User user) throws ExistingEmailException {
        String email = user.getEmail();

        if(userManager.findUserByEmail(email) != null)
            throw new ExistingEmailException();
    }
}
