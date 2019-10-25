package com.todopoject.springBoot.todolist.controller;

import com.todopoject.springBoot.todolist.model.Task;
import com.todopoject.springBoot.todolist.service.ITaskManager;
import com.todopoject.springBoot.todolist.service.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addTodo(@Valid @ModelAttribute Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "task";
        }
        taskManager.addTask(task);
        return "redirect:/tasks";
    }


    @GetMapping(value = "/updateTodo")
    public String updateTaskPage(Model model, @RequestParam int id) {
        model.addAttribute("newTodo", taskManager.getById(id));
        return "task";
    }
    @PostMapping(value = "/updateTodo")
    public String updateTask(@ModelAttribute Task task, BindingResult bindingResult, @RequestParam int id, String desc) {
        if(bindingResult.hasErrors()) {
            return "task";
        }
        taskManager.updateTask(desc, id);

        return "redirect:/tasks";
    }
}
