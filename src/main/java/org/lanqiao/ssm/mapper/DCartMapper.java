package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.ssm.pojo.Carts;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DCartMapper {
    @Select("select pro.pid,car.cartid,car.pnum,pro.pname,pro.pprice,prt.pimg from products pro,protype prt,carts car where pro.pid = prt.pid and car.pid=pro.pid and prt.moren = 1 and cid=#{cid}")
    public List<Carts> cartList(int cid);//根据顾客id查询购物车中所有内容
    @Insert("insert into carts(cid,pid,pnum) values(#{cid},#{pid},#{pnum})")
    public void addcar(Carts carts) ; //添加购物车
    @Delete("delete from carts where cartid=#{cartid}")
    public void  deletecar(int cartid);  //删除根据id
    @Select("select cartid,pnum,pid from carts where cartid=#{cartid}")
    public  Carts cartimByNo(int cartid); //根据id查找
    @Update("update carts set pnum=#{pnum} where pid=#{pid}")
    public void update(Carts carts);  //更新购物车
    @Delete("delete from carts where cid=#{cid}")
    public void deleteAll(int cid);  //删除全部
}
