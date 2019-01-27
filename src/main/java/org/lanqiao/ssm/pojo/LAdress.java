package org.lanqiao.ssm.pojo;
public class LAdress {
    private int adressid;
    private int cid;
    private String iname;
    private String address;
    private String shphone;
    private int c_default;
    private String quyu;

    public LAdress() {
    }

    public LAdress(int cid, String iname, String address, String shphone, int c_default, String quyu) {
        this.cid = cid;
        this.iname = iname;
        this.address = address;
        this.shphone = shphone;
        this.c_default = c_default;
        this.quyu = quyu;
    }

    public LAdress(int adressid, int cid, String iname, String address, String shphone, int c_default, String quyu) {
        this.adressid = adressid;
        this.cid = cid;
        this.iname = iname;
        this.address = address;
        this.shphone = shphone;
        this.c_default = c_default;
        this.quyu = quyu;
    }

    public int getAdressid() {
        return adressid;
    }

    public void setAdressid(int adressid) {
        this.adressid = adressid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getShphone() {
        return shphone;
    }

    public void setShphone(String shphone) {
        this.shphone = shphone;
    }

    public int getC_default() {
        return c_default;
    }

    public void setC_default(int c_default) {
        this.c_default = c_default;
    }

    public String getQuyu() {
        return quyu;
    }

    public void setQuyu(String quyu) {
        this.quyu = quyu;
    }

    @Override
    public String toString() {
        return "LAdress{" +
                "adressid=" + adressid +
                ", cid=" + cid +
                ", iname='" + iname + '\'' +
                ", address='" + address + '\'' +
                ", shphone='" + shphone + '\'' +
                ", c_default=" + c_default +
                ", quyu='" + quyu + '\'' +
                '}';
    }
}
