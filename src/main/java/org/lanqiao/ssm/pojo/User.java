package org.lanqiao.ssm.pojo;

public class User {
    private int uid;
    private String uname;
    private String password;
    private String phone;
    private String address;

    public User() {
    }

    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public User(int uid, String uname, String password, String phone, String address) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User(String uname, String password, String phone, String address) {
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
