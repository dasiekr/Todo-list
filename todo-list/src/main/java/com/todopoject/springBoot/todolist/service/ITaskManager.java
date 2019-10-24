package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.Task;

import java.util.List;

public interface ITaskManager {

    Task getById(int id);
    void addTask(Task task, String username);
    void updateTask(String description, int id);
    void deleteTask(int id);
    List<Task> getTasksByUsername();
}
