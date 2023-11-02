package com.ignatt.plann.service;

import com.ignatt.plann.dao.NotionDAO;
import com.ignatt.plann.entity.Notion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotionServiceImpl implements NotionService {

    @Autowired
    private NotionDAO notionDAO;

    @Override
    @Transactional
    public List<Notion> getAllNotions() {
        return notionDAO.getAllNotions();
    }

    @Override
    @Transactional
    public void saveNotion(Notion notion) {
        notionDAO.saveNotion(notion);
    }

    @Override
    @Transactional
    public Notion getNotion(int id) {
        return notionDAO.getNotion(id);
    }

    @Override
    @Transactional
    public void deleteNotion(int id) {
        notionDAO.deleteNotion(id);
    }
}
