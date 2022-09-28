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

    @GetMapping("/tasklist_tab1")
    public List<Task>showAllTaskTab1(){
        List<Task> allTaskTab1 = taskService.getAllTaskTab1();
        return allTaskTab1;
    }

    @GetMapping("/tasklist_tab2")
    public List<Task>showAllTaskTab2(){
        List<Task> allTaskTab2 = taskService.getAllTaskTab2();
        return allTaskTab2;
    }

    @GetMapping("/tasklist_tab3")
    public List<Task>showAllTaskTab3(){
        List<Task> allTaskTab3 = taskService.getAllTaskTab3();
        return allTaskTab3;
    }

    @GetMapping("/tasklist_tab4")
    public List<Task>showAllTaskTab4(){
        List<Task> allTaskTab4 = taskService.getAllTaskTab4();
        return allTaskTab4;
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
