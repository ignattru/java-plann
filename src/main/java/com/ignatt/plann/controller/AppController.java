package com.ignatt.plann.controller;

import com.ignatt.plann.entity.Task;
import com.ignatt.plann.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String showAllTask(Model model){
        List<Task> allTask = taskService.getAllTask();
        model.addAttribute("allTask", allTask);
        return "dashboard";
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateTask(@RequestParam("taskId") int id, Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "task-new";

    }

    @RequestMapping("/addNewTask")
    public String addNewEmployee(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "task-new";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
