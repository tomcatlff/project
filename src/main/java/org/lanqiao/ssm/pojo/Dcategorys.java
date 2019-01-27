package org.lanqiao.ssm.pojo;

public class Dcategorys {
    private int typeid;
    private String categorysname;

    public Dcategorys() {
    }

    public Dcategorys(String categorysname) {
        this.categorysname = categorysname;
    }

    public Dcategorys(int typeid, String categorysname) {
        this.typeid = typeid;
        this.categorysname = categorysname;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getCategorysname() {
        return categorysname;
    }

    public void setCategorysname(String categorysname) {
        this.categorysname = categorysname;
    }

    @Override
    public String toString() {
        return "Dcategorys{" +
                "typeid=" + typeid +
                ", categorysname='" + categorysname + '\'' +
                '}';
    }
}
