package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskDAO {

    public List<Task> getAllTask(int important);

    public int getCountTask(int important);

    public List<Task> getSubTasks(Integer taskId);

    public List<Task> getDoneSubTasks(Integer taskId);

    public List<Task> getAllTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
