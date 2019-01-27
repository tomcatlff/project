package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.LOrderInfoMapper;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LOrderInfo;
import org.lanqiao.ssm.pojo.LProducts;
import org.lanqiao.ssm.service.LOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ILOrderInfoImpl implements LOrderInfoService {
    @Autowired
    LOrderInfoMapper lOrderInfoMapper;
    @Override
    public List<LOrderInfo> findAllProByOid(int oid) {
        return lOrderInfoMapper.selectAllProByOid(oid);
    }

    @Override
    public LAdress findAdressById(int adressid) {
        return lOrderInfoMapper.selectAdressById(adressid);
    }

    @Override
    public List<LProducts> findAllProsByOid(int oid) {
        return lOrderInfoMapper.selectProductsInfo(oid);
    }

    @Override
    public void addOrderInfo(int oid, int pid, int num, Double price) {
        lOrderInfoMapper.insertOrderInfo(oid,pid,num,price);
    }
}
