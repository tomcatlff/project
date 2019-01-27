package org.lanqiao.ssm.service;



import org.lanqiao.ssm.pojo.*;

import java.util.List;

public interface IManagerService {
    //获取所有顾客
    public List<Wcustoms> findCusAll();

    //根据id删除顾客
    public void deleCus(int cid);

    //根据id需改顾客的状态---停用
    public void updateStateN(int cid);

    //根据id需改顾客的状态---启用
    public void updateStateY(int cid);

    //获取所有订单信息
    public List<CusOrder> findOrder();

    //根据id修改订单货物的状态
    public void modifyBstate(int oid);

    //根据id获取订单详情
    public List<WorderInfo> findOrderInfo(int oid);

    ////搜索---根据订单编号查询订单
    public List<CusOrder> findOrderByOid(int oid);

    //评论管理
    public List<ProductEval> findProductEval();

    //评论审核---根据评论的内容---通过
    public void updateProdEvalY(int eid);

    //评论审核---根据评论的内容---不通过
    public void updateProdEvalN(int eid);

    //根据id查询当前登录用户
    public Dadminstrators findAdminById(int aid);

//    //获取用户总数
//    public int getCusTotalNum();
//
//    //获取订单总数
//    public int getOrderTotalNum();
//
//    //用户分页
//    public List<Wcustoms> getCusPageList(int startIndex, int pageSize);
//
//    //订单分页
//    public List<CusOrder> findOrderPage(int startIndex, int pageSize);




}
