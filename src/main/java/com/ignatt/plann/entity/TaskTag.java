package com.ignatt.plann.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "tasktags")
public class TaskTag {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tagname")
    private String tagname;

    @Column(name = "createdate")
    private String createdate;

    @Column(name = "updatedate")
    private String updatedate;

    public TaskTag() {
    }

    public TaskTag(String tagname, String createdate, String updatedate) {
        this.tagname = tagname;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagname;
    }

    public void setTagName(String tagname) {
        this.tagname = tagname;
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


}
