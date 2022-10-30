package com.ignatt.plann.dao;

import com.ignatt.plann.entity.TaskTag;
import java.util.List;

public interface TaskTagDAO {
    public List<TaskTag> getAllTaskTag();

    public void saveTaskTag(TaskTag taskTag);

    public TaskTag getTaskTag(int id);

    public void deleteTaskTag(int id);
}
