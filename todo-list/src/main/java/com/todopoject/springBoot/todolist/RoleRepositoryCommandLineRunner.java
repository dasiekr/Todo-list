package com.todopoject.springBoot.todolist;

import com.todopoject.springBoot.todolist.model.Role;
import com.todopoject.springBoot.todolist.repository.RoleRepository;
import com.todopoject.springBoot.todolist.repository.UserRepository;
import com.todopoject.springBoot.todolist.service.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskManager taskManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
    }




}
