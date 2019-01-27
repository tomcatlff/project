package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


@Repository
public interface YSignupMapper {
    //查询所有员工
    @Select("select cid,cname,cpassword,phone from customs")
    public List<Customs> getAll() throws SQLException;
    //添加信息
    @Insert("insert into customs(cid,cname,cpassword,phone) values(#{cid},#{cname},#{cpassword},#{phone})")
    public void addUser(Customs customs) throws SQLException;

//    @Select("select * from custom")
//    public List<Customs> selectAllCustoms();
}
