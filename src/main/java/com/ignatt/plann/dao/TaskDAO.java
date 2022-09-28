package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskDAO {
    public List<Task> getAllTaskTab1();

    public List<Task> getAllTaskTab2();

    public List<Task> getAllTaskTab3();

    public List<Task> getAllTaskTab4();

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
