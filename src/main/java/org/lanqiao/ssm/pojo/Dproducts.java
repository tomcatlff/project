package org.lanqiao.ssm.pojo;

public class Dproducts {
    private int pid;
    private String pname;  //商品名称
    private String pinfo;  //商品介绍
    private int typeid;  //分类
    private  Double pprice;  //单价
    private Double disprice;  //打折后价格
    private  int pcounts;  //商品库存
    private  String rktime; //入库时间
    private  int redu;  //热度
    private int yon;//是否可用

    public Dproducts() {
    }

    public Dproducts(String pname, String pinfo, int typeid, Double pprice, Double disprice, int pcounts, String rktime, int redu) {
        this.pname = pname;
        this.pinfo = pinfo;
        this.typeid = typeid;
        this.pprice = pprice;
        this.disprice = disprice;
        this.pcounts = pcounts;
        this.rktime = rktime;
        this.redu = redu;
    }

    public Dproducts(int pid, String pname, String pinfo, int typeid, Double pprice, Double disprice, int pcounts, String rktime, int redu) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.typeid = typeid;
        this.pprice = pprice;
        this.disprice = disprice;
        this.pcounts = pcounts;
        this.rktime = rktime;
        this.redu = redu;
    }

    public Dproducts(int pid, String pname, String pinfo, int typeid, Double pprice, Double disprice, int pcounts, String rktime, int redu, int yon) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.typeid = typeid;
        this.pprice = pprice;
        this.disprice = disprice;
        this.pcounts = pcounts;
        this.rktime = rktime;
        this.redu = redu;
        this.yon = yon;
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

    public Double getDisprice() {
        return disprice;
    }

    public void setDisprice(Double disprice) {
        this.disprice = disprice;
    }

    public int getPcounts() {
        return pcounts;
    }

    public void setPcounts(int pcounts) {
        this.pcounts = pcounts;
    }

    public String getRktime() {
        return rktime;
    }

    public void setRktime(String rktime) {
        this.rktime = rktime;
    }

    public int getRedu() {
        return redu;
    }

    public void setRedu(int redu) {
        this.redu = redu;
    }

    public int getYon() {
        return yon;
    }

    public void setYon(int yon) {
        this.yon = yon;
    }

    @Override
    public String toString() {
        return "Dproducts{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", typeid=" + typeid +
                ", pprice=" + pprice +
                ", disprice=" + disprice +
                ", pcounts=" + pcounts +
                ", rktime='" + rktime + '\'' +
                ", redu=" + redu +
                ", yon=" + yon +
                '}';
    }
}
