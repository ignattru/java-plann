package com.ignatt.plann.dao;

import com.ignatt.plann.entity.TaskStatus;
import java.util.List;

public interface TaskStatusDAO {
    public List<TaskStatus> getAllTaskStatus();

    public void saveTaskStatus(TaskStatus taskstatus);

    public TaskStatus getTaskStatus(int id);

    public void deleteTaskStatus(int id);
}
