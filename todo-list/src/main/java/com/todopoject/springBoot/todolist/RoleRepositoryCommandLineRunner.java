package com.todopoject.springBoot.todolist;

import com.todopoject.springBoot.todolist.model.Role;
import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.repository.RoleRepository;
import com.todopoject.springBoot.todolist.repository.TaskRepository;
import com.todopoject.springBoot.todolist.repository.UserRepository;
import com.todopoject.springBoot.todolist.service.ITaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Component
public class RoleRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ITaskManager taskManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
//        Role adminRole = roleRepository.findByRole("ADMIN");
//        User admin1 = new User("MainAdmin", passwordEncoder.encode("admin"), "admin@gmail.com", new HashSet<Role>(Arrays.asList(adminRole)));
//        userRepository.save(admin1);

    }


}
