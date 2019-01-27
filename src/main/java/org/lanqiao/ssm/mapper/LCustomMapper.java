package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.*;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LCustomMapper {
//    根据cid查询用户信息
    @Select("SELECT cid,cname,phone FROM customs where cid=#{cid}")
    public LCustom selectCustomInfoByCid(int cid);
//    查询所有地址---数据库无法自增的原因---来确定主键大小
@Select("SELECT * FROM custominfo")
public List<LAdress> selectAllAdress();
//    根据cid查询用户收货地址
    @Select("SELECT * FROM custominfo WHERE cid =#{cid}")
    public List<LAdress> selectCAdressByCid(int cid);
//    更新cid更新信息
@Update("UPDATE customs SET cname=#{cname},phone=#{phone} where cid=#{cid} ")
    public void updateInfo(@Param("cname") String cname, @Param("phone") String phone, @Param("cid") int cid);
    //添加收货地址
    @Insert("INSERT INTO custominfo (adressid,cid,iname,address,shphone,c_default,quyu) VALUES (#{adressid},#{cid},#{iname},#{address},#{shphone},#{c_default},#{quyu})")
    public void addAdressByCid(LAdress adress);
//    删除地址
    @Delete("delete from custominfo where adressid=#{adressid}")
    public void deleteAdressByAdressid(int adressid);
//    更新地址
    @Update("UPDATE custominfo SET iname=#{iname}, shphone=#{shphone}, address=#{address} WHERE adressid=#{adressid}")
    public void updateAdressByAid(@Param("iname") String ianme, @Param("shphone") String shphone, @Param("address") String address, @Param("adressid") int adressid);
//    密码变更
    @Update("UPDATE customs set cpassword=#{newpassword} where cid=#{cid}")
    public void changePassWord(@Param("newpassword") String newpassword, @Param("cid") int cid);

    @Select("SELECT * FROM custominfo WHERE adressid =#{adressid}")
    public LAdress selectAdressById(int adressid);
}
