package org.lanqiao.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Wcustoms implements Serializable {
    private int cid;//用户编号
    private String cname;//用户姓名
//    private String iname;//收货人姓名
    private String cpassword;//密码
    private String phone;//手机号
//    private String address;//收货地址
//    private String shphone;//收货人电话
    private Double yue;//余额
    private int point;//积分
    private Date joindate;//加入的时间
    private int cusstate;//用户状态

    public Wcustoms() {
    }

    public Wcustoms(String cname, String cpassword, String phone, Double yue, int point, Date joindate, int cusstate) {
        this.cname = cname;
        this.cpassword = cpassword;
        this.phone = phone;
        this.yue = yue;
        this.point = point;
        this.joindate = joindate;
        this.cusstate = cusstate;
    }

    public Wcustoms(int cid, String cname, String cpassword, String phone, Double yue, int point, Date joindate, int cusstate) {
        this.cid = cid;
        this.cname = cname;
        this.cpassword = cpassword;
        this.phone = phone;
        this.yue = yue;
        this.point = point;
        this.joindate = joindate;
        this.cusstate = cusstate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getYue() {
        return yue;
    }

    public void setYue(Double yue) {
        this.yue = yue;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public int getCusstate() {
        return cusstate;
    }

    public void setCusstate(int cusstate) {
        this.cusstate = cusstate;
    }

    @Override
    public String toString() {
        return "Wcustoms{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", phone='" + phone + '\'' +
                ", yue=" + yue +
                ", point=" + point +
                ", joindate=" + joindate +
                ", cusstate=" + cusstate +
                '}';
    }
}
