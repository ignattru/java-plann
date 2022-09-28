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
    public List<Task> getAllTaskTab1() {
        return taskDAO.getAllTaskTab1();
    }

    @Override
    @Transactional
    public List<Task> getAllTaskTab2() {
        return taskDAO.getAllTaskTab2();
    }

    @Override
    @Transactional
    public List<Task> getAllTaskTab3() {
        return taskDAO.getAllTaskTab3();
    }

    @Override
    @Transactional
    public List<Task> getAllTaskTab4() {
        return taskDAO.getAllTaskTab4();
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
