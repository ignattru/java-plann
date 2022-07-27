package com.ignatt.plann.service;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
