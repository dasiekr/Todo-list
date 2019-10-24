package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.service.ITaskManager;
import com.todopoject.springBoot.todolist.service.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    IUserManager userManager;

    ITaskManager taskManager;

    @Autowired
    public TaskController(IUserManager userManager, ITaskManager taskManager) {
        this.userManager = userManager;
        this.taskManager = taskManager;
    }

    @GetMapping(value = {"/tasks", "/"})
    public String showTodos(Model model) {
        model.addAttribute("tasks", taskManager.getTasksByUsername());
        return "tasks2";
    }

    @PostMapping(value = "/deleteTodo/{id}")
    public String deleteTodo(@PathVariable int id) {
        taskManager.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/updateTodo/{id}")
    public String updateTodoPage(@PathVariable int id, Model model) {
        model.addAttribute("update", taskManager.getById(id));
        return "task";
    }

    @PostMapping(value = "/updateTodo/{id}")
    public String updateTask(@PathVariable int id, String description) {
        taskManager.updateTask(description, id);
        return "redirect:/tasks";
    }
}
