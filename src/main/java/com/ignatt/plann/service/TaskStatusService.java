package com.ignatt.plann.service;

import com.ignatt.plann.entity.TaskStatus;

import java.util.List;

public interface TaskStatusService {
    public List<TaskStatus> getAllTaskStatus();

    public void saveTaskStatus(TaskStatus taskstatus);

    public TaskStatus getTaskStatus(int id);

    public void deleteTaskStatus(int id);
}
