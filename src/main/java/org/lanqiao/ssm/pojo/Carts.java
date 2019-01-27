package org.lanqiao.ssm.pojo;

public class Carts {
    private int cartid;
    private int cid;
    private int pid;
    private int pnum;
    private String pname;
    private Double pprice;
    private String pimg;




    public Carts() {
    }

    public Carts(int cid, int pid, int pnum) {
        this.cid = cid;
        this.pid = pid;
        this.pnum = pnum;
    }

    public Carts(int cartid, int cid, int pid, int pnum) {
        this.cartid = cartid;
        this.cid = cid;
        this.pid = pid;
        this.pnum = pnum;
    }

    public Carts(int cid, int pid, int pnum, String pname, Double pprice, String pimg) {
        this.cid = cid;
        this.pid = pid;
        this.pnum = pnum;
        this.pname = pname;
        this.pprice = pprice;
        this.pimg = pimg;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
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

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "cartid=" + cartid +
                ", cid=" + cid +
                ", pid=" + pid +
                ", pnum=" + pnum +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", pimg='" + pimg + '\'' +
                '}';
    }
}
