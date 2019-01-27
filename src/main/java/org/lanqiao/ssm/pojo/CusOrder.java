package org.lanqiao.ssm.pojo;


import java.util.Date;

public class CusOrder {
    private int oid;//订单id
    private String iname;//该订单的收货人姓名
    private String address;//订单的收货地址
    private int ostateid;//订单的状态
    private int bstateid;//商品的状态
    private int totalnum;//订单数量
    private double totalprice;//订单总价
    private int discount;//
    private double totalprice_dis;
    private Date createtime;//订单的创建时间

    public CusOrder() {
    }

    public CusOrder(String iname, String address, int ostateid, int bstateid, int totalnum, double totalprice, int discount, double totalprice_dis, Date createtime) {
        this.iname = iname;
        this.address = address;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.totalnum = totalnum;
        this.totalprice = totalprice;
        this.discount = discount;
        this.totalprice_dis = totalprice_dis;
        this.createtime = createtime;
    }

    public CusOrder(int oid, String iname, String address, int ostateid, int bstateid, int totalnum, double totalprice, int discount, double totalprice_dis, Date createtime) {
        this.oid = oid;
        this.iname = iname;
        this.address = address;
        this.ostateid = ostateid;
        this.bstateid = bstateid;
        this.totalnum = totalnum;
        this.totalprice = totalprice;
        this.discount = discount;
        this.totalprice_dis = totalprice_dis;
        this.createtime = createtime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
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

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getTotalprice_dis() {
        return totalprice_dis;
    }

    public void setTotalprice_dis(double totalprice_dis) {
        this.totalprice_dis = totalprice_dis;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "CusOrder{" +
                "oid=" + oid +
                ", iname='" + iname + '\'' +
                ", address='" + address + '\'' +
                ", ostateid=" + ostateid +
                ", bstateid=" + bstateid +
                ", totalnum=" + totalnum +
                ", totalprice=" + totalprice +
                ", discount=" + discount +
                ", totalprice_dis=" + totalprice_dis +
                ", createtime=" + createtime +
                '}';
    }
}
