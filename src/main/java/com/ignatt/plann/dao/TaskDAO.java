package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskDAO {

    public List<Task> getAllTask(int important);

    public int getCountTask(int important);

    public int getCountSubTask(int taskid);

    public int getCountDoneSubTask(int taskid);

    public List<Task> getAllTasks();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
