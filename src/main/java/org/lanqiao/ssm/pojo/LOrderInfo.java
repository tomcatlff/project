package org.lanqiao.ssm.pojo;

public class LOrderInfo {
    private int oid;
    private int pid;
    private String pname;
    private Double pprice;
    private int counts;
    private Double ptprice;

    public LOrderInfo() {
    }

    public LOrderInfo(int pid, String pname, Double pprice, int counts, Double ptprice) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.counts = counts;
        this.ptprice = ptprice;
    }

    public LOrderInfo(int oid, int pid, String pname, Double pprice, int counts, Double ptprice) {
        this.oid = oid;
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.counts = counts;
        this.ptprice = ptprice;
    }

}
