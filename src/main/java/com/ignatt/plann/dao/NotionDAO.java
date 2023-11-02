package com.ignatt.plann.dao;

import com.ignatt.plann.entity.Notion;

import java.util.List;

public interface NotionDAO {
    public List<Notion> getAllNotions();

    public void saveNotion(Notion notion);

    public Notion getNotion(int id);

    public void deleteNotion(int id);
}
