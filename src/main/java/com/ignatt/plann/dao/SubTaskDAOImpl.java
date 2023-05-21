package com.ignatt.plann.dao;

import com.ignatt.plann.entity.SubTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubTaskDAOImpl implements SubTaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SubTask> getAllSubTasks() {
        Session session = sessionFactory.getCurrentSession();
        Query<SubTask> query = session.createQuery("from SubTask", SubTask.class);
        List<SubTask> allSubTask = query.getResultList();
        return allSubTask;
    }

    @Override
    public void saveSubTask(SubTask subtask) {
        Session session  = sessionFactory.getCurrentSession();
        session.saveOrUpdate(subtask);
    }

    @Override
    public SubTask getSubTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        SubTask subtask = session.get(SubTask.class, id);
        return subtask;
    }

    @Override
    public void deleteSubTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<SubTask> query = session.createQuery("delete from SubTask " + "where id=:taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();
    }
}
