package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.lanqiao.ssm.pojo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagetMapper {
    //获取用户信息
    @Select("select cid,cname,phone,cpassword,yue,point,joindate,cusstate from customs")
    public List<Wcustoms> selectCusAll();

    //根据id删除顾客
    @Delete("delete from customs where cid=#{cid}")
    public void deleteCus(int cid);

    //根据id需改顾客的状态---启用
    @Select("update customs set cusstate=0 where cid=#{cid}")
    public void updateStateY(int cid);

    //根据id需改顾客的状态---禁用
    @Select("update customs set cusstate=1 where cid=#{cid}")
    public void updateStateN(int cid);


    //获取订单信息
    @Select("select o.oid,cus.iname,cus.address,o.ostateid,o.bstateid,o.totalnum,o.totalprice,o.discount,o.totalprice_dis,o.createtime from orders o,custominfo cus where o.adressid=cus.adressid")
    public List<CusOrder> selectOrder();

    //根据id修改订单货物的状态
    @Select("update orders set bstateid=2  where oid=#{oid}")
    public void updateBstate(int oid);

    //根据id获取订单详情
    @Select("select o.oid,o.pid,p.pname,p.pinfo,c.categorysname,o.counts,o.ptprice from orderinfo o,products p,categorys c where o.pid=p.pid and p.typeid=c.typeid and o.oid=#{o.oid}")
    public List<WorderInfo> selectOrderInfo(int oid);

    //搜索---根据订单编号查询订单
    @Select("select o.oid,cus.iname,cus.address,o.ostateid,o.bstateid,o.totalnum,o.totalprice,o.discount,o.totalprice_dis,o.createtime from orders o,custominfo cus where o.adressid=cus.adressid and o.oid=#{o.oid}")
    public List<CusOrder> selectOrderByOid(int oid);


    //评论管理
    @Select("select e.eid,e.cid,c.cname,p.pname,e.evaluate,e.creatdate,e.passid from evaluates e,products p,customs c where e.pid=p.pid and e.cid=c.cid")
    public List<ProductEval> selectProductEval();

    //评论审核---根据评论的内容--->审核通过
    @Select("update evaluates set passid=1  where  eid=#{eid}" )
    public void updateEvalStateY(int eid);

    //评论审核---根据评论的内容--->审核不通过
    @Select("update evaluates set passid=2  where eid=#{eid}")
    public void updateEvalStateN(int eid);

    //根据id查询当前登录用户
    @Select("select * from adminstrators where aid=#{aid}")
    public Dadminstrators selectAdminById(int aid);


}
