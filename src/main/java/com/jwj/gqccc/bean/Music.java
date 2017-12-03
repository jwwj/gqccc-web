package com.jwj.gqccc.bean;

public class Music {
    private Integer mid;

    private String maddress;

    private String mmusicname;

    private String mcd;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress == null ? null : maddress.trim();
    }

    public String getMmusicname() {
        return mmusicname;
    }

    public void setMmusicname(String mmusicname) {
        this.mmusicname = mmusicname == null ? null : mmusicname.trim();
    }

    public String getMcd() {
        return mcd;
    }

    public void setMcd(String mcd) {
        this.mcd = mcd == null ? null : mcd.trim();
    }
}