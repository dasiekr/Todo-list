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

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

    @Override
    public Task getById(int id) {
        return taskRepository.getOne(id);
    }

    @Override
    public void addTask(Task task) {
        Task newTask = new Task();
        newTask.setStatus(task.getStatus());
        newTask.setTargetDate(task.getTargetDate());
        newTask.setUsername(getLoggedInUserName());
        newTask.setDescription(task.getDescription());
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
