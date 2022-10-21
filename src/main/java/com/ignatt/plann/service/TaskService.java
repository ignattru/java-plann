package com.ignatt.plann.service;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskService {

    public List<Task> getAllTask(int important);

    public List<Task> getAllTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
