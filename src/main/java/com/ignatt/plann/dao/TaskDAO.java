package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Task;
import java.util.List;

public interface TaskDAO {

    public List<Task> getAllTask(int important);

    public void saveTask(Task task);

    public Task getTask(int id);

    public void deleteTask(int id);
}
