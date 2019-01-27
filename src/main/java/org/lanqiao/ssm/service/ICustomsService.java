package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.Jproducts;

import java.util.List;

public interface ICustomsService {
    public List<Customs> findAll();
    public Customs findCustomsById(int cid);

    //根据商品称字搜索商品
    public List<Jproducts> fingGoodsByPname(String Pname);

    //价格区间查询
    public List<Jproducts>  fingGoodsByPcounts(Double Pprice, Double Pprice1);



}
