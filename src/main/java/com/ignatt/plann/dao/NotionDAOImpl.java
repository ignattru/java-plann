package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Notion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotionDAOImpl implements NotionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Notion> getAllNotions() {
        Session session = sessionFactory.getCurrentSession();
        Query<Notion>query = session.createQuery("from Notion", Notion.class);
        List<Notion> allNotions = query.getResultList();
        return allNotions;
    }

    @Override
    public void saveNotion(Notion notion) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(notion);
    }

    @Override
    public Notion getNotion(int id) {
        Session session = sessionFactory.getCurrentSession();
        Notion notion = session.get(Notion.class, id);
        return notion;
    }

    @Override
    public void deleteNotion(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Notion> query = session.createQuery("delete from Notion" + "where id=:notionId");
        query.setParameter("notionId", id);
        query.executeUpdate();
    }

}
