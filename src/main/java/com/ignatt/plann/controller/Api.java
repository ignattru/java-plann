package com.ignatt.plann.controller;

import com.ignatt.plann.entity.Task;
import com.ignatt.plann.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasklist")
    public List<Task>showAllEmployees(){
        List<Task> allEmployees = taskService.getAllTask();
        return allEmployees;
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id){
        Task task = taskService.getTask(id);
        return task;
    }

    @PostMapping("/tasklist")
    public Task addNewTask(@RequestBody Task task){
        taskService.saveTask(task);
        return task;
    }

    @PutMapping("/tasklist")
    public Task updateTask(@RequestBody Task task){
        taskService.saveTask(task);
        return task;
    }

    @DeleteMapping("/task/{id}")
    public String deleteTask (@PathVariable int id){
        Task task = taskService.getTask(id);
        taskService.deleteTask(id);
        return "Task with ID = " + id + "was deleted";
    }
}
