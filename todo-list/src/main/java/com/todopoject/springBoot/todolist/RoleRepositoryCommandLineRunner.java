package com.todopoject.springBoot.todolist;

import com.todopoject.springBoot.todolist.model.Role;
import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.repository.RoleRepository;
import com.todopoject.springBoot.todolist.repository.TaskRepository;
import com.todopoject.springBoot.todolist.repository.UserRepository;
import com.todopoject.springBoot.todolist.service.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Component
public class RoleRepositoryCommandLineRunner implements CommandLineRunner {

    RoleRepository roleRepository;

    UserRepository userRepository;

    TaskRepository taskRepository;

    TaskManager taskManager;

    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RoleRepositoryCommandLineRunner(RoleRepository roleRepository, UserRepository userRepository, TaskRepository taskRepository, TaskManager taskManager, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.taskManager = taskManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        taskRepository.save(new Task("Pierwsze zadanie", new Date(), "To do", "springuser"));
        taskRepository.save(new Task("Drugie zadanie", new Date(), "To do", "springuser"));
        Role userRole = roleRepository.findByRole("USER");
        User user = new User("springuser", passwordEncoder.encode("qwerty"), "springuser@gmail.com", "qwerty", new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }




}
