package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.YProductsMapper;
import org.lanqiao.ssm.pojo.Products;
import org.lanqiao.ssm.service.IYProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YProductsServiceImpl implements IYProductsService {
    @Autowired
    YProductsMapper yProductsMapper;
    @Override
    public List<Products> getinfo1() {
        List<Products> productsList = yProductsMapper.getinfo1();
        return productsList;
    }

    @Override
    public List<Products> getinfo2() {
        List<Products> productsList = yProductsMapper.getinfo2();
        return productsList;
    }

    @Override
    public List<Products> getinfo3() {
        List<Products> productsList = yProductsMapper.getinfo3();
        return productsList;
    }

    @Override
    public List<Products> getinfo4() {
        List<Products> productsList = yProductsMapper.getinfo4();
        return productsList;
    }

    @Override
    public List<Products> getinfo5() {
        List<Products> productsList = yProductsMapper.getinfo5();
        return productsList;
    }

    @Override
    public Products selectProductsById(int pid) {
        Products products = yProductsMapper.selectProductsById(pid);
        return products;
    }
    @Override
    public List<Products> products(int typeid,int pid) {
//        List<Products> productsList = yProductsMapper.products(typeid);
//        System.out.println(productsList.size());
        return yProductsMapper.products(typeid,pid);
    }

    @Override
    public List<Products> moreProduct() {
        return yProductsMapper.moreProduct();
    }

    @Override
    public List<Products> sameProduct(int pid) {
        return yProductsMapper.sameProduct(pid);
    }
}
