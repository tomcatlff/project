package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dadminstrators;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface DadminMapper {
    //添加
    public void insertAdmin(Dadminstrators dadminstrators);
    //查询
    public List<Dadminstrators> selectAdminAll(Condation condation);
    //数量
    public int selectAdminCount();
    //删除
    public void deleteAdmintById(int aid);
    //更新
    public void updateAdminById(Dadminstrators dadminstrators);

    //通过id查找
    public Dadminstrators selectAdminById(int aid);
    //通过姓名查找
    public Dadminstrators selectAdminByName(String name);
    //全部查询
    public List<Dadminstrators> selectAdminAll();
}
