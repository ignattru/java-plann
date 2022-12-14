package com.ignatt.plann.controller;

import com.ignatt.plann.entity.Task;
import com.ignatt.plann.entity.TaskTag;
import com.ignatt.plann.service.TaskService;
import com.ignatt.plann.service.TaskTagService;
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
    private TaskTagService taskTagService;


    @RequestMapping("/")
    public String showAllTask(Model model) {
        List<Task> allTaskTab1 = taskService.getAllTask(1);
            model.addAttribute("allTaskTab1", allTaskTab1);
        List<Task> allTaskTab2 = taskService.getAllTask(2);
            model.addAttribute("allTaskTab2", allTaskTab2);
        List<Task> allTaskTab3 = taskService.getAllTask(3);
            model.addAttribute("allTaskTab3", allTaskTab3);
        List<Task> allTaskTab4 = taskService.getAllTask(4);
        model.addAttribute("allTaskTab4", allTaskTab4);
        return "dashboard";
    }

    @RequestMapping("/saveTask")
    public String saveTask (@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateTask ( @RequestParam("taskId") int id, Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "task-new";
    }

    @RequestMapping("/addNewTask")
    public String addNewEmployee (Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "task-new";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask ( @RequestParam("taskId") int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
