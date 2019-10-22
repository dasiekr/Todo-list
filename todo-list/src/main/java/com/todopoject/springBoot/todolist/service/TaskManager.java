package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskManager implements ITaskManager{

    @Autowired
    TaskRepository taskRepository;


    private String getLoggedInUserName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Override
    public Task getById(int id) {
        return taskRepository.getOne(id);
    }

    @Override
    public void addTask(Task task, String username) {
        task.setDone(false);
        task.setTargetDate(new Date());
        task.setUsername(getLoggedInUserName());
        task.setDescription(task.getDescription());
        taskRepository.save(task);
    }

    @Override
    public void updateTask(String description, int id) {
        Task task = getById(id);
        task.setDescription(description);
        task.setTargetDate(new Date());
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}