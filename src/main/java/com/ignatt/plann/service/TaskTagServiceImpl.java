package com.ignatt.plann.service;


import com.ignatt.plann.dao.TaskTagDAO;
import com.ignatt.plann.entity.TaskTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class TaskTagServiceImpl implements TaskTagService {

    @Autowired
    private TaskTagDAO tasktagDAO;

    @Override
    @Transactional
    public List<TaskTag> getAllTaskTag() {
        return tasktagDAO.getAllTaskTag();
    }

    @Override
    @Transactional
    public void saveTaskTag(TaskTag taskTag) {
        tasktagDAO.saveTaskTag(taskTag);
    }

    @Override
    @Transactional
    public TaskTag getTaskTag(int id) {
        return tasktagDAO.getTaskTag(id);
    }

    @Override
    @Transactional
    public void deleteTaskTag(int id) {
        tasktagDAO.deleteTaskTag(id);
    }

}
