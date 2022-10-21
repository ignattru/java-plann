package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Task> getAllTask(int important) {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task where important = " + important, Task.class);
        List<Task> allTask = query.getResultList();
        return allTask;
    }

    @Override
    public List<Task> getAllTasks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task", Task.class);
        List<Task> allTask = query.getResultList();
        return allTask;
    }

    @Override
    public void saveTask(Task task) {
        Session session  = sessionFactory.getCurrentSession();
        session.saveOrUpdate(task);
    }

    @Override
    public Task getTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        return task;
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Task> query = session.createQuery("delete from Task " + "where id=:taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();
    }
}