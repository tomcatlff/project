package org.lanqiao.ssm.pojo;

public class Dadminstrators {
    private int aid;
    private String aname;
    private String aphone;
    private  String apassword;
    private String email;
    private String address;

    public Dadminstrators() {
    }

    public Dadminstrators(int aid, String aname, String aphone) {
        this.aid = aid;
        this.aname = aname;
        this.aphone = aphone;
    }

    public Dadminstrators(String aname, String aphone, String apassword, String email, String address) {
        this.aname = aname;
        this.aphone = aphone;
        this.apassword = apassword;
        this.email = email;
        this.address = address;
    }

    public Dadminstrators(int aid, String aname, String aphone, String email, String address) {
        this.aid = aid;
        this.aname = aname;
        this.aphone = aphone;
        this.email = email;
        this.address = address;
    }

    public Dadminstrators(int aid, String aname, String aphone, String apassword, String email, String address) {
        this.aid = aid;
        this.aname = aname;
        this.aphone = aphone;
        this.apassword = apassword;
        this.email = email;
        this.address = address;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dadminstrators{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", aphone='" + aphone + '\'' +
                ", apassword='" + apassword + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
