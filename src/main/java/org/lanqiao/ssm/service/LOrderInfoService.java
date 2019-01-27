package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LOrderInfo;
import org.lanqiao.ssm.pojo.LProducts;

import java.util.List;

public interface LOrderInfoService {
//    查询该订单的所有商品
    public List<LOrderInfo> findAllProByOid(int oid);
//    查询收货信息
    public LAdress findAdressById(int adressid);
//    根据订单id查询订单详情表中商品并获取对应的商品信息
    public List<LProducts> findAllProsByOid(int oid);

    //    创建订单详情
    public void addOrderInfo(int oid,int pid,int num,Double price);
}
