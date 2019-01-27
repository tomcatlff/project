package org.lanqiao.ssm.pojo;

import org.springframework.beans.factory.annotation.Value;

public class Jproducts {

    private int Pid;
    private String Pname;
    private String Pinfo;
    private String Typeid;
    private Double Pprice;
    private Double Pprice1;
    private int Pcounts;
    private String Rktime;
    private String Redu;
    private String pimg;

    public Jproducts() {
    }

    public Jproducts(int pid, String pname, String pinfo, String typeid, Double pprice, Double pprice1, int pcounts, String rktime, String redu, String pimg) {
        Pid = pid;
        Pname = pname;
        Pinfo = pinfo;
        Typeid = typeid;
        Pprice = pprice;
        Pprice1 = pprice1;
        Pcounts = pcounts;
        Rktime = rktime;
        Redu = redu;
        this.pimg = pimg;
    }

    public Jproducts(int pid, String pname, String pinfo, String typeid, Double pprice, Double pprice1, int pcounts, String rktime, String redu) {
        Pid = pid;
        Pname = pname;
        Pinfo = pinfo;
        Typeid = typeid;
        Pprice = pprice;
        Pprice1 = pprice1;
        Pcounts = pcounts;
        Rktime = rktime;
        Redu = redu;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPinfo() {
        return Pinfo;
    }

    public void setPinfo(String pinfo) {
        Pinfo = pinfo;
    }

    public String getTypeid() {
        return Typeid;
    }

    public void setTypeid(String typeid) {
        Typeid = typeid;
    }

    public Double getPprice() {
        return Pprice;
    }

    public void setPprice(Double pprice) {
        Pprice = pprice;
    }

    public Double getPprice1() {
        return Pprice1;
    }

    public void setPprice1(Double pprice1) {
        Pprice1 = pprice1;
    }

    public int getPcounts() {
        return Pcounts;
    }

    public void setPcounts(int pcounts) {
        Pcounts = pcounts;
    }

    public String getRktime() {
        return Rktime;
    }

    public void setRktime(String rktime) {
        Rktime = rktime;
    }

    public String getRedu() {
        return Redu;
    }

    public void setRedu(String redu) {
        Redu = redu;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Override
    public String toString() {
        return "Jproducts{" +
                "Pid=" + Pid +
                ", Pname='" + Pname + '\'' +
                ", Pinfo='" + Pinfo + '\'' +
                ", Typeid='" + Typeid + '\'' +
                ", Pprice=" + Pprice +
                ", Pprice1=" + Pprice1 +
                ", Pcounts=" + Pcounts +
                ", Rktime='" + Rktime + '\'' +
                ", Redu='" + Redu + '\'' +
                ", pimg='" + pimg + '\'' +
                '}';
    }
}