package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.error.DifferentPasswordException;
import com.todopoject.springBoot.todolist.error.ExistingEmailException;
import com.todopoject.springBoot.todolist.error.ExistingUsernameException;
import com.todopoject.springBoot.todolist.model.Role;
import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.repository.RoleRepository;
import com.todopoject.springBoot.todolist.repository.UserRepository;
import com.todopoject.springBoot.todolist.service.IUserManager;
import com.todopoject.springBoot.todolist.service.UserManager;
import com.todopoject.springBoot.todolist.validator.IUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    IUserManager userManager;

    IUserValidator userValidator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(IUserManager userManager, IUserValidator userValidator) {
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

    @GetMapping(value = "/todos")
    public String todosPage() {
        return "todos";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        userManager.logout();
        return "logout";
    }
}
