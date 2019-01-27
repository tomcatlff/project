package org.lanqiao.ssm.pojo;

import java.util.Date;

public class LCustomsOrders {
    private int oid;
    private int cid;
    private String cname;
    private String iname;
    private int adressid;
    private String address;
    private int ostateid;
    private int bstateid;
    private Double totalprice;
    private String createtime;

    public LCustomsOrders() {
    }

    public LCustomsOrders(int oid, int ostateid, int bstateid, Double totalprice, String createtime) {
        this.oid = oid;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.totalprice = totalprice;
        this.createtime = createtime;
    }

    public LCustomsOrders(int cid, String cname, String iname, int adressid, String address, int ostateid, int bstateid, Double totalprice, String createtime) {
        this.cid = cid;
        this.cname = cname;
        this.iname = iname;
        this.adressid = adressid;
        this.address = address;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.totalprice = totalprice;
        this.createtime = createtime;
    }

    public LCustomsOrders(int oid, int cid, String cname, String iname, int adressid, String address, int ostateid, int bstateid, Double totalprice, String createtime) {
        this.oid = oid;
        this.cid = cid;
        this.cname = cname;
        this.iname = iname;
        this.adressid = adressid;
        this.address = address;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.totalprice = totalprice;
        this.createtime = createtime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public int getAdressid() {
        return adressid;
    }

    public void setAdressid(int adressid) {
        this.adressid = adressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOstateid() {
        return ostateid;
    }

    public void setOstateid(int ostateid) {
        this.ostateid = ostateid;
    }

    public int getBstateid() {
        return bstateid;
    }

    public void setBstateid(int bstateid) {
        this.bstateid = bstateid;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "LCustomsOrders{" +
                "oid=" + oid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", iname='" + iname + '\'' +
                ", adressid=" + adressid +
                ", address='" + address + '\'' +
                ", ostateid=" + ostateid +
                ", bstateid=" + bstateid +
                ", totalprice=" + totalprice +
                ", createtime=" + createtime +
                '}';
    }
}
