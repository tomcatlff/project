package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.LCustomOrdersMapper;
import org.lanqiao.ssm.pojo.LCustomsOrders;
import org.lanqiao.ssm.service.LCustomOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ILCustomOrderImpl implements LCustomOrdersService {
    @Autowired
    LCustomOrdersMapper lCustomOrdersMapper;
    @Override
    public List<LCustomsOrders> findAllOrderByCid(int cid) {
        return lCustomOrdersMapper.selectAllOrderById(cid);
    }

    @Override
    public void updataBstateid(int oid) {
        lCustomOrdersMapper.updataBstate(oid);
    }

    @Override
    public LCustomsOrders getOrederStateByOid(int oid) {
        return lCustomOrdersMapper.selectOrderByOid(oid);
    }

    @Override
    public void addOrder(int oid, int cid, int adressid, int totalnum, Double totalprice, Date createtime) {
        lCustomOrdersMapper.insertOrder(oid, cid, adressid, totalnum, totalprice, createtime);
    }

    @Override
    public void change(int pid,int count) {
        lCustomOrdersMapper.updateProductcount(pid,count);
    }

    @Override
    public void quxiaoOrderByOid(int oid) {
        lCustomOrdersMapper.quxiaoOrderByOid(oid);
    }
}
