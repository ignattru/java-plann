package com.ignatt.plann.service;

import com.ignatt.plann.dao.SubTaskDAO;
import com.ignatt.plann.entity.SubTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubTaskServiceImpl implements SubTaskService {

    @Autowired
    private SubTaskDAO subTaskDAO;

    @Override
    @Transactional
    public List<SubTask> getAllSubTasks() {
        return subTaskDAO.getAllSubTasks();
    }

    @Override
    @Transactional
    public void saveSubTask(SubTask subtask) {
        subTaskDAO.saveSubTask(subtask);
    }

    @Override
    @Transactional
    public SubTask getSubTask(int id) {
        return subTaskDAO.getSubTask(id);
    }

    @Override
    @Transactional
    public void deleteSubTask(int id) {
        subTaskDAO.deleteSubTask(id);
    }
}
