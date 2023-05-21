package com.ignatt.plann.service;

import com.ignatt.plann.entity.SubTask;

import java.util.List;

public interface SubTaskService {

    public List<SubTask> getAllSubTasks();

    public void saveSubTask(SubTask subtask);

    public SubTask getSubTask(int id);

    public void deleteSubTask(int id);
}
