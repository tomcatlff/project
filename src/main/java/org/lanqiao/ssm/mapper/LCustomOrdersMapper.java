package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.ssm.pojo.LCustomsOrders;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LCustomOrdersMapper {
//    根据用户id查询其所有订单
    @Select("SELECT o.oid,cs.cid,cs.cname,ci.iname,ci.adressid,ci.address,o.ostateid,o.bstateid,o.createtime FROM orders o,customs cs,custominfo ci where o.cid=cs.cid AND o.adressid=ci.adressid AND cs.cid=#{cid} ORDER BY o.createtime DESC")
    public List<LCustomsOrders> selectAllOrderById(int cid);
//    确认收货
    @Update("UPDATE orders SET ostateid=1 ,bstateid=2 WHERE oid=#{oid}")
    public void updataBstate(int oid);
//    根据订单id查询订单状态
    @Select("SELECT oid,ostateid,bstateid,createtime,totalprice,createtime FROM orders where oid=#{oid};")
    public LCustomsOrders selectOrderByOid(int oid);

    //    创建订单
    @Insert("insert into orders (oid,cid,adressid,ostateid,bstateid,totalnum,totalprice,createtime) values (#{oid},#{cid},#{adressid},0,0,#{totalnum},#{totalprice},#{createtime})")
    public void insertOrder(@Param("oid") int oid, @Param("cid") int cid, @Param("adressid") int adressid, @Param("totalnum") int totalnum, @Param("totalprice") Double totalprice, @Param("createtime") Date createtime);
    @Update("UPDATE products set pcounts = pcounts-#{count}, redu = redu+1 WHERE pid = #{pid};")
    public void updateProductcount(@Param("pid") int pid,@Param("count")int count);
//    取消订单
    @Update("UPDATE orders SET ostateid=2,bstateid=2 WHERE oid=#{oid}")
    public void quxiaoOrderByOid(int oid);
}
