package com.jwj.gqccc.bean;

public class User {
    private String uid;

    private String uphoneinfo;

    private Integer uscore;

    private Integer ulevel;

    private Integer udelnum;

    private Integer uidenum;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUphoneinfo() {
        return uphoneinfo;
    }

    public void setUphoneinfo(String uphoneinfo) {
        this.uphoneinfo = uphoneinfo == null ? null : uphoneinfo.trim();
    }

    public Integer getUscore() {
        return uscore;
    }

    public void setUscore(Integer uscore) {
        this.uscore = uscore;
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    public Integer getUdelnum() {
        return udelnum;
    }

    public void setUdelnum(Integer udelnum) {
        this.udelnum = udelnum;
    }

    public Integer getUidenum() {
        return uidenum;
    }

    public void setUidenum(Integer uidenum) {
        this.uidenum = uidenum;
    }
}