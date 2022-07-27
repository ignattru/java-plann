package com.ignatt.plann.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userlist")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "fio")
    private String fio;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "departmentid")
    private int departmentid;

    @Column(name = "createdate")
    private Date createdate;

    @Column(name = "updatedate")
    private Date updatedate;

    public User() {
    }

    public User(String login, String fio, String password, int enabled, int departmentid, Date createdate, Date updatedate) {
        this.login = login;
        this.fio = fio;
        this.password = password;
        this.enabled = enabled;
        this.departmentid = departmentid;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getDepartmentid() {
        return departmentid;
    }
    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }


}
