package com.ignatt.plann.service;

import com.ignatt.plann.dao.TaskDAO;
import com.ignatt.plann.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional
    public List<Task> getAllTask(int important) {
        return taskDAO.getAllTask(important);
    }

    @Override
    @Transactional
    public int getCountTask(int important) {
        return taskDAO.getCountTask(important);
    }

    @Override
    @Transactional
    public int getCountSubTask(int taskid) {
        return taskDAO.getCountSubTask(taskid);
    }

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    @Transactional
    public void saveTask(Task task) {
        taskDAO.saveTask(task);
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        return taskDAO.getTask(id);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
