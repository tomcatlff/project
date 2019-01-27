package org.lanqiao.ssm.pojo;

public class Categorys {
    private int typeid;
    private String categorysname;

    public Categorys() {
    }

    public Categorys(int typeid, String categorysname) {
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
        return "Categorys{" +
                "typeid=" + typeid +
                ", categorysname='" + categorysname + '\'' +
                '}';
    }
}
