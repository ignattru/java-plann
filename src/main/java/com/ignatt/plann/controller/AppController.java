package com.ignatt.plann.controller;
import com.ignatt.plann.entity.Task;
import com.ignatt.plann.service.TaskService;
import com.ignatt.plann.service.TaskTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private TaskService taskService;
    private TaskTagService taskTagService;

    @GetMapping("/")
    public String showAllTask(Model model) {

        List<Task> allTaskTab1 = taskService.getAllTask(1);
            model.addAttribute("allTaskTab1", allTaskTab1);
        List<Task> allTaskTab2 = taskService.getAllTask(2);
            model.addAttribute("allTaskTab2", allTaskTab2);
        List<Task> allTaskTab3 = taskService.getAllTask(3);
            model.addAttribute("allTaskTab3", allTaskTab3);
        List<Task> allTaskTab4 = taskService.getAllTask(4);
            model.addAttribute("allTaskTab4", allTaskTab4);

        int countTaskTab1 = taskService.getCountTask(1);
        model.addAttribute("countTaskTab1", countTaskTab1);

        int countTaskTab2 = taskService.getCountTask(2);
        model.addAttribute("countTaskTab2", countTaskTab2);

        int countTaskTab3 = taskService.getCountTask(3);
        model.addAttribute("countTaskTab3", countTaskTab3);

        int countTaskTab4 = taskService.getCountTask(4);
        model.addAttribute("countTaskTab4",countTaskTab4);

        /*  test method for subtask count by id task
        int countSubTask = taskService.getCountSubTaskById(42);
        model.addAttribute("countSubTask",countSubTask);

        int countDoneSubTask = taskService.getCountDoneSubTaskById(42);
        model.addAttribute("countDoneSubTask",countDoneSubTask);
        */

        return "dashboard";
    }

    // Create task
    @GetMapping("/addNewTask")
    public String addNewEmployee (Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "task-edit";
    }

    // Read task
    @GetMapping("/viewTask")
    public String viewTask ( @RequestParam("taskId") int id, Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "task-view";
    }

    // Update task
    @GetMapping("/updateInfo")
    public String updateTask ( @RequestParam("taskId") int id, Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        List<Task> allTask = taskService.getAllTasks();
        model.addAttribute("allTask", allTask);
        return "task-edit";
    }

    // Delete task
    @DeleteMapping("/deleteTask")
    public String deleteTask ( @RequestParam("taskId") int id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    // Save task
    @PostMapping("/saveTask")
    public String saveTask (@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }






}
