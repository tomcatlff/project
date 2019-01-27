package org.lanqiao.ssm.pojo;

public class Customs {
    private int cid;
    private String cname;
    private String cpassword;
    private String phone;

    public Customs() {
    }

    public Customs(int cid, String cname, String cpassword, String phone) {
        this.cid = cid;
        this.cname = cname;
        this.cpassword = cpassword;
        this.phone = phone;
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

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customs{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
