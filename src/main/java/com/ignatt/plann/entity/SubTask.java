package com.ignatt.plann.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasklist_subtasks")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "taskid")
    private int taskid;

    @Column(name = "subtaskid")
    private int subtaskid;

    public SubTask() {
    }

    public SubTask( int taskid, int subtaskid) {
        this.taskid = taskid;
        this.subtaskid = subtaskid;
    }

}


