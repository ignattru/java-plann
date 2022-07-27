package com.ignatt.plann.dao;

import com.ignatt.plann.entity.TaskStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskStatusDAOImpl implements TaskStatusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TaskStatus> getAllTaskStatus() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaskStatus> query = session.createQuery("from TaskStatus", TaskStatus.class);
        List<TaskStatus> allTaskStatus = query.getResultList();
        return allTaskStatus;
    }

    @Override
    public void saveTaskStatus(TaskStatus taskstatus) {
        Session session  = sessionFactory.getCurrentSession();
        session.saveOrUpdate(taskstatus);
    }

    @Override
    public TaskStatus getTaskStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
        TaskStatus taskstatus = session.get(TaskStatus.class, id);
        return taskstatus;
    }

    @Override
    public void deleteTaskStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<TaskStatus> query = session.createQuery("delete from TaskStatus" + "where id=:taskstatusId");
        query.setParameter("taskstatusId", id);
        query.executeUpdate();
    }

}
