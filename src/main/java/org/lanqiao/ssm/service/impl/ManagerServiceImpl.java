package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.ManagetMapper;
import org.lanqiao.ssm.pojo.*;
import org.lanqiao.ssm.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    ManagetMapper managetMapper;

    //获取所有顾客信息
//    @Override
//    public List<Wcustoms> findCusAll(int currentPage,int pageSize) {
//        PageHelper.startPage(currentPage,pageSize);
//        List<Wcustoms> customsList = managetMapper.selectCusAll();
//        PageBean<Wcustoms> pageCustom = new PageBean<>(currentPage,pageSize,)
//        return managetMapper.selectCusAll();
//    }

    @Override
    public List<Wcustoms> findCusAll() {
//        PageHelper.startPage(1,1);
        return managetMapper.selectCusAll();
    }

    //根据id删除顾客
    @Override
    public void deleCus(int cid) {
        managetMapper.deleteCus(cid);
    }

    //根据id需改顾客的状态---停用
    @Override
    public void updateStateN(int cid) {
        managetMapper.updateStateN(cid);
    }

    //根据id需改顾客的状态---启用
    @Override
    public void updateStateY(int cid) {
        managetMapper.updateStateY(cid);
    }

    //获取所有订单的信息
    @Override
    public List<CusOrder> findOrder() {
        return managetMapper.selectOrder();
    }

    //根据id修改订单货物的状态
    @Override
    public void modifyBstate(int oid) {
        managetMapper.updateBstate(oid);
    }

    //根据id获取订单详情
    @Override
    public List<WorderInfo> findOrderInfo(int oid) {
        return managetMapper.selectOrderInfo(oid);
    }

    //搜索---根据订单编号查询订单
    @Override
    public List<CusOrder> findOrderByOid(int oid) {
        return managetMapper.selectOrderByOid(oid);
    }

    //评论管理
    @Override
    public List<ProductEval> findProductEval() {
        return managetMapper.selectProductEval();
    }

    //评论审核---根据评论的内容---通过
    @Override
    public void updateProdEvalY(int eid) {
        managetMapper.updateEvalStateY(eid);
    }

    //评论审核---根据评论的内容---不通过
    @Override
    public void updateProdEvalN(int eid) {
        managetMapper.updateEvalStateN(eid);
    }

    //根据id查询当前登录用户
    @Override
    public Dadminstrators findAdminById(int aid) {
        return managetMapper.selectAdminById(aid);
    }

//    //获取用户总数
//    @Override
//    public int getCusTotalNum() {
//        return managetMapper.getCusTotalNun();
//    }
//
//    //获取订单总数
//    @Override
//    public int getOrderTotalNum() {
//        return managetMapper.getOrderTotalNum();
//    }
//
//    //用户分页
//    @Override
//    public List<Wcustoms> getCusPageList(int startIndex, int pageSize) {
//        PageHelper.startPage(startIndex,pageSize);
//        return managetMapper.findCusPageList(startIndex,pageSize);
//    }
//
//    //订单分页
//    @Override
//    public List<CusOrder> findOrderPage(int startIndex, int pageSize) {
//        return managetMapper.findOrderPageList(startIndex,pageSize);
//    }

}
