package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface YLoginMapper {
    //查询所有员工
    @Select("select cid,cname,cpassword,phone from customs")
    public List<Customs> getAll() throws SQLException;
    @Select("select * from customs where cname = #{cname}")
    public Customs getuser(String cname);
}
