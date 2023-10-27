package com.ignatt.plann.controller;
import com.ignatt.plann.entity.CountsPair;
import com.ignatt.plann.entity.Task;
import com.ignatt.plann.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String showAllTask(Model model) {

        int countTaskTab1 = taskService.getCountTask(1);
        model.addAttribute("countTaskTab1", countTaskTab1);

        int countTaskTab2 = taskService.getCountTask(2);
        model.addAttribute("countTaskTab2", countTaskTab2);

        int countTaskTab3 = taskService.getCountTask(3);
        model.addAttribute("countTaskTab3", countTaskTab3);

        int countTaskTab4 = taskService.getCountTask(4);
        model.addAttribute("countTaskTab4",countTaskTab4);

        List<Task> tasks = taskService.getAllTasks();
        Map<Task, CountsPair> tasksWithCountTab1 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab2 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab3 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab4 = new HashMap<>();

        for (Task task : tasks) {
            List<Task> subTasks = taskService.getSubTasks(task.getId());
            List<Task> doneSubTasks = taskService.getDoneSubTasks(task.getId());

            CountsPair countsPair = new CountsPair(subTasks.size(), doneSubTasks.size());
            switch (task.getImportant()) {
                case 1:
                    tasksWithCountTab1.put(task, countsPair);
                    break;
                case 2:
                    tasksWithCountTab2.put(task, countsPair);
                    break;
                case 3:
                    tasksWithCountTab3.put(task, countsPair);
                    break;
                case 4:
                    tasksWithCountTab4.put(task, countsPair);
                    break;
            }
        }

        model.addAttribute("tasksWithCountTab1", tasksWithCountTab1);
        model.addAttribute("tasksWithCountTab2", tasksWithCountTab2);
        model.addAttribute("tasksWithCountTab3", tasksWithCountTab3);
        model.addAttribute("tasksWithCountTab4", tasksWithCountTab4);

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
    @GetMapping("/deleteTask")
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
