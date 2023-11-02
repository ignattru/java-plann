package com.ignatt.plann.entity;

import javax.persistence.*;

@Entity
@Table(name = "taskstatus")
public class Notion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "enabled")
    private int enabled;

    public Notion() {
    }

    public Notion(String title, String body, int enabled) {
        this.title = title;
        this.body = body;
        this.enabled = enabled;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
