package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManagerImpl implements TaskManager {

    TaskRepository taskRepository;

    @Autowired
    public TaskManagerImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private String getLoggedInUserName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }


    @Override
    public Task getById(int id) {
        return taskRepository.getOne(id);
    }

    @Override
    public void addTask(Task task) {
        Task newTask = new Task();
        newTask.setUsername(getLoggedInUserName());
        newTask.setDescription(task.getDescription());
        newTask.setTargetDate(task.getTargetDate());
        newTask.setStatus(task.getStatus());
        taskRepository.save(newTask);
    }

    @Override
    public void updateTask(Task task, int id) {
        Task updateTask = getById(id);
        updateTask.setUsername(getLoggedInUserName());
        updateTask.setDescription(task.getDescription());
        updateTask.setTargetDate(task.getTargetDate());
        updateTask.setStatus(task.getStatus());
        taskRepository.save(updateTask);
    }



    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByUsername() {
        return taskRepository.getTasksByUsername(getLoggedInUserName());
    }
}
