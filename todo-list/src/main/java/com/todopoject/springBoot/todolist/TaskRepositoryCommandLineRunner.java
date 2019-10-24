package com.todopoject.springBoot.todolist;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        taskRepository.save(new Task("Pierwsze zadanie", new Date(), false, "adamek1997"));
        taskRepository.save(new Task("Drugie zadanie", new Date(), false, "adamek1997"));
        System.out.println(taskRepository.findAll().size());
    }
}
