package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.service.TaskManager;
import com.todopoject.springBoot.todolist.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TaskController {

    UserManager userManager;

    TaskManager taskManager;


    @Autowired
    public TaskController(UserManager userManager, TaskManager taskManager) {
        this.userManager = userManager;
        this.taskManager = taskManager;
    }

    @GetMapping(value = {"/tasks", "/"})
    public String showTodos(Model model) {
        model.addAttribute("tasks", taskManager.getTasksByUsername());
        return "tasks";
    }

    @PostMapping(value = "/deleteTodo/{id}")
    public String deleteTodo(@PathVariable int id) {
        taskManager.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/addTodo")
    public String addTodoPage(Model model) {
        model.addAttribute("newTodo", new Task());
        return "task";
    }

    @PostMapping(value = "/addTodo")
    public String addTodo(@ModelAttribute Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "task";
        }
        taskManager.addTask(task);
        return "redirect:/tasks";
    }


    @GetMapping(value = "/updateTodo/{id}")
    public String updateTaskPage(Model model, @PathVariable int id) {
        model.addAttribute("updateTodo", taskManager.getById(id));
        return "update";
    }
    
    @PostMapping(value = "/updateTodo/{id}")
    public String updateTask(@PathVariable int id, @ModelAttribute Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "task";
        }

        taskManager.updateTask(task, id);

        return "redirect:/tasks";
    }
}
