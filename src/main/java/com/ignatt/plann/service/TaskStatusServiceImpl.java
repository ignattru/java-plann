package com.ignatt.plann.service;

import com.ignatt.plann.dao.TaskStatusDAO;
import com.ignatt.plann.entity.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

    @Autowired
    private TaskStatusDAO taskstatusDAO;

    @Override
    @Transactional
    public List<TaskStatus> getAllTaskStatus() {
        return taskstatusDAO.getAllTaskStatus();
    }

    @Override
    @Transactional
    public void saveTaskStatus(TaskStatus taskstatus) {
        taskstatusDAO.saveTaskStatus(taskstatus);
    }

    @Override
    @Transactional
    public TaskStatus getTaskStatus(int id) {
        return taskstatusDAO.getTaskStatus(id);
    }

    @Override
    @Transactional
    public void deleteTaskStatus(int id) {
        taskstatusDAO.deleteTaskStatus(id);
    }

}
