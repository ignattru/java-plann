package com.ignatt.plann.dao;

import com.ignatt.plann.entity.SubTask;

import java.util.List;

public interface SubTaskDAO {
    public List<SubTask> getAllSubTasks();

    public void saveSubTask(SubTask task);

    public SubTask getSubTask(int id);

    public void deleteSubTask(int id);
}
