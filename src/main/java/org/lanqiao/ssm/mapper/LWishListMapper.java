package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.LWishList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LWishListMapper {
    @Select("SELECT wi.cid,p.pid,p.pname,pro.pimg,p.pinfo,p.pprice,p.pcounts FROM wishlist wi,products p,protype pro WHERE wi.pid=p.pid AND p.pid=pro.pid AND wi.cid=#{cid} AND pro.moren=1;")
    public List<LWishList> selectAllWishByCid(int cid);
//    移除
    @Delete("delete from wishlist where pid=#{pid} and cid=#{cid}")
    public void deleteWishListByPid(@Param("pid") int pid, @Param("cid") int cid);

    //    添加
    @Insert("INSERT INTO wishlist (cid,pid) VALUES (#{cid},#{pid})")
    public void InsertWishList(@Param("cid")int cid,@Param("pid")int pid);
}
