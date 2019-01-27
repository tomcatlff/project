package org.lanqiao.ssm.pojo;

import java.util.Date;

public class WorderInfo {
   private int oid;//订单id
   private int pid;//产品id
   private String pname;//产品的名字
   private String pinfo;//产品信息
   private String categorysname;//产品类别
    private int counts;//该产品的数量
    private String ptprice;//价格


    public WorderInfo() {
    }

    public WorderInfo(int pid, String pname, String pinfo, String categorysname, int counts, String ptprice) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.categorysname = categorysname;
        this.counts = counts;
        this.ptprice = ptprice;
    }

    public WorderInfo(int oid, int pid, String pname, String pinfo, String categorysname, int counts, String ptprice) {
        this.oid = oid;
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.categorysname = categorysname;
        this.counts = counts;
        this.ptprice = ptprice;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public String getCategorysname() {
        return categorysname;
    }

    public void setCategorysname(String categorysname) {
        this.categorysname = categorysname;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getPtprice() {
        return ptprice;
    }

    public void setPtprice(String ptprice) {
        this.ptprice = ptprice;
    }

    @Override
    public String toString() {
        return "WorderInfo{" +
                "oid=" + oid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", categorysname='" + categorysname + '\'' +
                ", counts=" + counts +
                ", ptprice='" + ptprice + '\'' +
                '}';
    }
}
