package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.CustomMapper;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.Jproducts;
import org.lanqiao.ssm.service.ICustomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomsServiceImpl implements ICustomsService {
    @Autowired
    CustomMapper customMapper;
    @Override
    public List<Customs> findAll() {
        return customMapper.selectAll();
    }

    @Override
    public Customs findCustomsById(int cid) {
        return customMapper.selectCustomsById(cid);
    }

    //通过商品名称查询商品
    @Override
    public List<Jproducts>  fingGoodsByPname(String Pname) {
        return customMapper.selectGoodsByPname(Pname);
    }

    //通过价格区间查询商品信息
    @Override
    public List<Jproducts> fingGoodsByPcounts(Double Pprice, Double Pprice1) {
        return  customMapper.selectGoodsByPcounts(Pprice, Pprice1);
    }


}
