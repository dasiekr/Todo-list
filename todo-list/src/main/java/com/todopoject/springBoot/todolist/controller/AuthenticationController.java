package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/rest/auth/")
public class AuthenticationController {


    @GetMapping("/process")
    public String process() {
        return "processing";
    }

}
