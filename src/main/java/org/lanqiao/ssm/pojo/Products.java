package org.lanqiao.ssm.pojo;

public class Products {
    private int pid;
    private String pname;
    private String pinfo;
    private int typeid;
    private Double pprice;
    private int pcounts;
    private String redu;
    private String pimg;
    private String categorysname;

    public Products() {
    }

    public Products(int pid, String pname, String pinfo, int typeid, Double pprice, int pcounts, String redu, String pimg, String categorysname) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.typeid = typeid;
        this.pprice = pprice;
        this.pcounts = pcounts;
        this.redu = redu;
        this.pimg = pimg;
        this.categorysname = categorysname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public int getPcounts() {
        return pcounts;
    }

    public void setPcounts(int pcounts) {
        this.pcounts = pcounts;
    }

    public String getRedu() {
        return redu;
    }

    public void setRedu(String redu) {
        this.redu = redu;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getCategorysname() {
        return categorysname;
    }

    public void setCategorysname(String categorysname) {
        this.categorysname = categorysname;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", typeid=" + typeid +
                ", pprice=" + pprice +
                ", pcounts=" + pcounts +
                ", redu='" + redu + '\'' +
                ", pimg='" + pimg + '\'' +
                ", categorysname='" + categorysname + '\'' +
                '}';
    }
}
