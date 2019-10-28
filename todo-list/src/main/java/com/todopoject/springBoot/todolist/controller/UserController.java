package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.error.DifferentPasswordException;
import com.todopoject.springBoot.todolist.error.ExistingEmailException;
import com.todopoject.springBoot.todolist.error.ExistingUsernameException;
import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.service.UserManager;
import com.todopoject.springBoot.todolist.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    UserManager userManager;

    UserValidator userValidator;


    @Autowired
    public UserController(UserManager userManager, UserValidator userValidator) {
        this.userManager = userManager;
        this.userValidator = userValidator;
    }

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userData", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@Valid @ModelAttribute("userData") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        try {
            userValidator.userValidation(user);
        } catch (ExistingUsernameException e) {
            model.addAttribute("existingUsername", e.getMessage());
            return "registration";
        } catch (DifferentPasswordException e) {
            model.addAttribute("differentPasswords", e.getMessage());
            return "registration";
        } catch (ExistingEmailException e) {
            model.addAttribute("existingEmail", e.getMessage());
            return "registration";
        }

        userManager.userRegistration(user);
        model.addAttribute("userDataLogin", new User());
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("userDataLogin", new User());
        return "login";
    }

}
