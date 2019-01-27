package org.lanqiao.ssm.service;



import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dadminstrators;

import java.util.List;

public interface IAdminService {
    //添加
    public void insertAdmin2(Dadminstrators dadminstrators);
    //查询
    public List<Dadminstrators> selectAdminAll2(Condation condation);
    //数量
    public int selectAdminCount2();
    //删除
    public void deleteAdmintById2(int aid);
    //更新
    public void updateAdminById2(Dadminstrators dadminstrators);
    //通过id查找
    public Dadminstrators selectAdminById2(int aid);

    public Dadminstrators selectAdminByName(String name);
    public List<Dadminstrators> selectAdminAll2();
}
