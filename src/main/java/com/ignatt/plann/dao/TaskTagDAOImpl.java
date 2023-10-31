package com.ignatt.plann.dao;

import com.ignatt.plann.entity.TaskStatus;
import com.ignatt.plann.entity.TaskTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskTagDAOImpl implements TaskTagDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaskTag> getAllTaskTag() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaskTag>query = session.createQuery("from TaskTag", TaskTag.class);
        List<TaskTag> allTaskTag = query.getResultList();
        return allTaskTag;
    }


    @Override
    public void saveTaskTag(TaskTag taskTag) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(taskTag);
    }

    @Override
    public TaskTag getTaskTag(int id) {
        Session session = sessionFactory.getCurrentSession();
        TaskTag taskTag = session.get(TaskTag.class, id);
        return taskTag;
    }

    @Override
    public void deleteTaskTag(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<TaskTag> query = session.createQuery("delete from TaskTag" + "where id=:taskTagId");
        query.setParameter("taskTagId", id);
        query.executeUpdate();
    }

}

