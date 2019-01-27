package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustom;

import java.util.List;

public interface LCustomInfoService {
//    根据cid查询用户信息
    public LCustom findCustomByCid(int cid);
//    根据所有收货地址
    public List<LAdress> findAllAdress();
//    根据cid查询用户的收货地址
    public List<LAdress> findAllAdressByCid(int cid);
//    根据cid更新用户信息
    public void modifyCustomInfo(String cname, String phone, int cid);
//    添加收货地址
    public void addAdress(LAdress adress);
//    删除地址
    public void delAdress(int adressid);
//    更新地址
    public void updateAdrss(String ianme, String shphone, String address, int adressid);
//    密码变更
    public void changePwdByCid(String newPwd, int cid);

    //    根据aid查地址
    public LAdress findeadress(int aid);
}
