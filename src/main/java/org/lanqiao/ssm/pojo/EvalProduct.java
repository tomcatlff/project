package org.lanqiao.ssm.pojo;

public class EvalProduct {
    private int pid;//评价的产品
    private String cname;//评价人
    private int cid;
    private String evaluate;//评价内容
    private String creatdate;//创建时间
    private int passid;

    public EvalProduct() {
    }

    public EvalProduct(int pid, int cid, String evaluate) {
        this.pid = pid;
        this.cid = cid;
        this.evaluate = evaluate;
    }

    public EvalProduct(int pid, int cid, String evaluate, String creatdate, int passid) {
        this.pid = pid;
        this.cid = cid;
        this.evaluate = evaluate;
        this.creatdate = creatdate;
        this.passid = passid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(String creatdate) {
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
        return "EvalProduct{" +
                "pid=" + pid +
                ", cname='" + cname + '\'' +
                ", cid=" + cid +
                ", evaluate='" + evaluate + '\'' +
                ", creatdate='" + creatdate + '\'' +
                ", passid=" + passid +
                '}';
    }
}
