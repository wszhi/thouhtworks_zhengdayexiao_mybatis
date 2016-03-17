package com.wsz.entity;


import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;  

  
@Entity  
@Table(name="user")
public class User {  
  
    @Id
    private String userid;
    private String name;
    private String psw;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}