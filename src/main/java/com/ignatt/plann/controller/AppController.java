package com.ignatt.plann.controller;
import com.ignatt.plann.entity.CountsPair;
import com.ignatt.plann.entity.Task;
import com.ignatt.plann.entity.TaskStatus;
import com.ignatt.plann.service.TaskService;
import com.ignatt.plann.service.TaskStatusService;
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
    private TaskStatusService taskStatusService;

    @GetMapping("/")
    public String showAllTask(Model model) {

        // Get all tasks
        List<Task> tasks = taskService.getAllTasks();

        // Create hashmap for each tab by important field
        Map<Task, CountsPair> tasksWithCountTab1 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab2 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab3 = new HashMap<>();
        Map<Task, CountsPair> tasksWithCountTab4 = new HashMap<>();

        for (Task task : tasks) {

            // Get subtasks and done subtasks
            List<Task> subTasks = taskService.getSubTasks(task.getId());
            List<Task> doneSubTasks = taskService.getDoneSubTasks(task.getId());

            // Create pairs "count subtask","count done subtasks"
            CountsPair countsPair = new CountsPair(subTasks.size(), doneSubTasks.size());
            switch (task.getImportant()) {
                case 1:
                    tasksWithCountTab1.put(task, countsPair);
                    model.addAttribute("countTaskTab1", tasksWithCountTab1.size());
                    break;
                case 2:
                    tasksWithCountTab2.put(task, countsPair);
                    model.addAttribute("countTaskTab2", tasksWithCountTab2.size());
                    break;
                case 3:
                    tasksWithCountTab3.put(task, countsPair);
                    model.addAttribute("countTaskTab3", tasksWithCountTab3.size());
                    break;
                case 4:
                    tasksWithCountTab4.put(task, countsPair);
                    model.addAttribute("countTaskTab4", tasksWithCountTab4.size());
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

        // Get all tasks for select parent task
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
