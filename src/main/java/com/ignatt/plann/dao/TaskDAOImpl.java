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
    public List<Task> getAllTaskTab1() {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task where important = 1", Task.class);
        List<Task> allTaskTab1 = query.getResultList();
        return allTaskTab1;
    }

    @Override
    public List<Task> getAllTaskTab2() {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task where important = 2", Task.class);
        List<Task> allTaskTab2 = query.getResultList();
        return allTaskTab2;
    }

    @Override
    public List<Task> getAllTaskTab3() {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task where important = 3", Task.class);
        List<Task> allTaskTab3 = query.getResultList();
        return allTaskTab3;
    }

    @Override
    public List<Task> getAllTaskTab4() {
        Session session = sessionFactory.getCurrentSession();
        Query<Task>query = session.createQuery("from Task where important = 4", Task.class);
        List<Task> allTaskTab4 = query.getResultList();
        return allTaskTab4;
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