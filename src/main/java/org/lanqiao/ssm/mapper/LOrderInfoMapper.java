package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LOrderInfo;
import org.lanqiao.ssm.pojo.LProducts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LOrderInfoMapper {
//    根据订单id查询该订单中所有的商品
    @Select("SELECT oi.oid,oi.pid,pro.pname,pro.pprice,oi.counts,oi.ptprice FROM orderinfo oi,products pro WHERE oi.pid=pro.pid AND oi.oid=#{oid}")
    public List<LOrderInfo> selectAllProByOid(int oid);
//根据订单中地址id查询对应的地址信息
    @Select("select * from custominfo where adressid=#{adressid}")
    public LAdress selectAdressById(int adressid);
//    根据订单id查询订单详情表中商品并获取对应的商品信息
    @Select("SELECT p.pid,p.pname,p.pinfo,p.pprice,pty.size,pty.colors,pty.pimg from orderinfo o,products p,protype pty WHERE o.pid=p.pid AND p.pid=pty.pid AND pty.moren=1 AND o.oid=#{oid}")
    public List<LProducts> selectProductsInfo(int oid);

    //    创建订单详情
    @Update("insert into orderinfo(oid,pid,counts,ptprice)values(#{oid},#{pid},#{counts},#{ptprice})")
    public void insertOrderInfo(@Param("oid") int oid, @Param("pid") int pid, @Param("counts") int counts, @Param("ptprice") Double ptprince);
}
