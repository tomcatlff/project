package org.lanqiao.ssm.pojo;

public class LProducts {
    private int pid;
    private String pname;
    private String pinfo;
    private Double pprice;
    private String size;
    private String colors;
    private String pimg;

    public LProducts() {
    }

    public LProducts(String pname, String pinfo, Double pprice, String size, String colors, String pimg) {
        this.pname = pname;
        this.pinfo = pinfo;
        this.pprice = pprice;
        this.size = size;
        this.colors = colors;
        this.pimg = pimg;
    }

    public LProducts(int pid, String pname, String pinfo, Double pprice, String size, String colors, String pimg) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.pprice = pprice;
        this.size = size;
        this.colors = colors;
        this.pimg = pimg;
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

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    @Override
    public String toString() {
        return "LProducts{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", pprice=" + pprice +
                ", size='" + size + '\'' +
                ", coclors='" + colors + '\'' +
                ", pimg='" + pimg + '\'' +
                '}';
    }
}
