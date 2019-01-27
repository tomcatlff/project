package org.lanqiao.ssm.pojo;

public class Condation {
    private  String typeid;
    private String pname;
    private String rktime;
    private String aname;

    public Condation() {
    }

    public Condation(String aname) {
        this.aname = aname;
    }

    public Condation(String typeid, String pname, String rktime) {
        this.typeid = typeid;
        this.pname = pname;
        this.rktime = rktime;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRktime() {
        return rktime;
    }

    public void setRktime(String rktime) {
        this.rktime = rktime;
    }

    @Override
    public String toString() {
        return "Condation{" +
                "typeid='" + typeid + '\'' +
                ", pname='" + pname + '\'' +
                ", rktime='" + rktime + '\'' +
                '}';
    }
}
