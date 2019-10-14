package com.todopoject.springBoot.todolist;

import com.todopoject.springBoot.todolist.model.Role;
import com.todopoject.springBoot.todolist.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
    }
}
