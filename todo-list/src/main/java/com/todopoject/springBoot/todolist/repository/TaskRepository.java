package com.todopoject.springBoot.todolist.repository;

import com.todopoject.springBoot.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> getTasksByUsername(String username);
}
