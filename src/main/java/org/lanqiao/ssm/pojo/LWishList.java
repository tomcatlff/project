package org.lanqiao.ssm.pojo;

public class LWishList {
    private int cid;
    private int pid;
    private String pname;
    private String pimg;
    private String pinfo;
    private Double pprice;
    private int pcounts;

    public LWishList() {
    }

    public LWishList(int pid, String pname, String pimg, String pinfo, Double pprice, int pcounts) {
        this.pid = pid;
        this.pname = pname;
        this.pimg = pimg;
        this.pinfo = pinfo;
        this.pprice = pprice;
        this.pcounts = pcounts;
    }

    public LWishList(int cid, int pid, String pname, String pimg, String pinfo, Double pprice, int pcounts) {
        this.cid = cid;
        this.pid = pid;
        this.pname = pname;
        this.pimg = pimg;
        this.pinfo = pinfo;
        this.pprice = pprice;
        this.pcounts = pcounts;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
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

    @Override
    public String toString() {
        return "LWishList{" +
                "cid=" + cid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pimg='" + pimg + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", pprice=" + pprice +
                ", pcounts=" + pcounts +
                '}';
    }
}
