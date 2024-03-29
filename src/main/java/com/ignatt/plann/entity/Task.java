package com.ignatt.plann.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "tasklist")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "important")
    private int important;

    @Column(name = "reportid")
    private Integer reportid;

    @Column(name = "status")
    private int status;

    @Column(name = "tagid")
    private int tagid;

    @Column(name = "makerid")
    private int makerid;

    @Column(name = "createdate")
    private String createdate;

    @Column(name = "updatedate")
    private String updatedate;

    @Column(name = "plandate")
    private String plandate;

    @Column(name = "closedate")
    private String closedate;

    @Column(name = "parenttask")
    private int parenttask;

    @OneToOne
    @JoinColumn(name = "makerid", insertable=false, updatable=false)
    private User taskUser;

    @OneToOne
    @JoinColumn(name = "status", insertable=false, updatable=false)
    private TaskStatus taskStatus;

    @OneToOne
    @JoinColumn(name = "tagid", insertable=false, updatable=false)
    private TaskTag taskTag;

    public Task() {
    }

    public Task(String title, String body, int important, Integer reportid, int status, int tagid, int makerid, String createdate, String updatedate, String plandate, String closedate, int parenttask) {
        this.title = title;
        this.body = body;
        this.important = important;
        this.reportid = reportid;
        this.status = status;
        this.tagid = tagid;
        this.makerid = makerid;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.plandate = plandate;
        this.closedate = closedate;
        this.parenttask = parenttask;
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
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public int getImportant() {
        return important;
    }
    public void setImportant(int important) {
        this.important = important;
    }

    public Integer getReportId() {
        return reportid;
    }
    public void setReportId(Integer reportid) {
        this.reportid = reportid;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public int getTagId() {
        return tagid;
    }
    public void setTagId(int tagid) {
        this.tagid = tagid;
    }

    public int getMakerid() {
        return makerid;
    }
    public void setMakerid(int makerid) {
        this.makerid = makerid;
    }

    public String getCreatedate() {
        return createdate;
    }
    public void setCreatedate(String createdate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        this.createdate = createdate;
        try {
            Date createdated = formatter.parse(createdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(String updatedate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        this.updatedate = updatedate;
        try {
            Date updatedated = formatter.parse(updatedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPlandate() {
        return plandate;
    }
    public void setPlandate(String plandate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        this.plandate = plandate;
        try {
            Date plandated = formatter.parse(plandate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getClosedate() {
        return closedate;
    }

    public void setClosedate(String closedate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
        this.closedate = closedate;
        try {
            Date closedated = formatter.parse(closedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getParentTask() {
        return parenttask;
    }

    public void setParentTask(int parenttask) {
        this.parenttask = parenttask;
    }

    public User getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(User taskUser) {
        this.taskUser = taskUser;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskTag getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(TaskTag taskTag) {
        this.taskTag = taskTag;
    }

}
