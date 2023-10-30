package com.ignatt.plann.entity;

import javax.persistence.*;

@Entity
@Table(name = "taskstatus")
public class TaskStatus {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "statusname")
    private String statusname;

    public TaskStatus() {
    }

    public TaskStatus(String statusname) {
        this.statusname = statusname;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getStatusname() {
        return statusname;
    }
    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }


}
