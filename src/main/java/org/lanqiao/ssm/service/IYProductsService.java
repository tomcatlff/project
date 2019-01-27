package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Products;

import java.util.List;

public interface IYProductsService {
    public List<Products> getinfo1();
    public List<Products> getinfo2();
    public List<Products> getinfo3();
    public List<Products> getinfo4();
    public List<Products> getinfo5();

    public Products selectProductsById(int pid);

    public List<Products> products(int typeid,int pid);
    public List<Products> moreProduct();
    public List<Products> sameProduct(int pid);
}
