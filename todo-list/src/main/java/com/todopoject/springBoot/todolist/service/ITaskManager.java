package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.Task;

public interface ITaskManager {

    Task getById(int id);
    void addTask(Task task, String username);
    void updateTask(String description, int id);
    void deleteTask(int id);
}
