package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.LCustomsOrders;

import java.util.Date;
import java.util.List;

public interface LCustomOrdersService {
//    查询该用户所有订单
    public List<LCustomsOrders> findAllOrderByCid(int cid);
//    确认收货
    public void updataBstateid(int oid);
//    根据id查询订单状态
    public LCustomsOrders getOrederStateByOid(int oid);

    //    创建订单
    public void addOrder(int oid, int cid,int adressid,int totalnum,Double totalprice, Date createtime);
//    商品数量减少，热度增加
    public  void change(int pid,int count);
//    取消订单
    public void quxiaoOrderByOid(int oid);
}
