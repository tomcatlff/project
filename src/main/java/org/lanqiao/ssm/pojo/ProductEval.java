package org.lanqiao.ssm.pojo;

import java.util.Date;

public class ProductEval {
    private int eid;//编辑者id
    private int cid;//顾客id
    private String cname;//顾客姓名
    private int pid;//商品id
    private String pname;//商品名称
    private String evaluate;//商品评价
    private Date creatdate;//订单评论的时间
    private int passid;//审核是否通过  0表示未通过   1表示通过

    public ProductEval() {
    }

    public ProductEval(int cid, String cname, int pid, String pname, String evaluate, Date creatdate, int passid) {
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
        this.pname = pname;
        this.evaluate = evaluate;
        this.creatdate = creatdate;
        this.passid = passid;
    }

    public ProductEval(int eid, String cname, String pname, String evaluate, Date creatdate, int passid) {
        this.eid = eid;
        this.cname = cname;
        this.pname = pname;
        this.evaluate = evaluate;
        this.creatdate = creatdate;
        this.passid = passid;
    }

    public ProductEval(int eid, int cid, String cname, String pname, String evaluate, Date creatdate, int passid) {
        this.eid = eid;
        this.cid = cid;
        this.cname = cname;
        this.pname = pname;
        this.evaluate = evaluate;
        this.creatdate = creatdate;
        this.passid = passid;
    }

    public ProductEval(int eid, int cid, String cname, int pid, String pname, String evaluate, Date creatdate, int passid) {
        this.eid = eid;
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
        this.pname = pname;
        this.evaluate = evaluate;
        this.creatdate = creatdate;
        this.passid = passid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
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

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    @Override
    public String toString() {
        return "ProductEval{" +
                "eid=" + eid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", creatdate=" + creatdate +
                ", passid=" + passid +
                '}';
    }
}
