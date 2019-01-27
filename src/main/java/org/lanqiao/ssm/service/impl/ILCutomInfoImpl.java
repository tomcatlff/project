package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.LCustomMapper;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustom;
import org.lanqiao.ssm.service.LCustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILCutomInfoImpl implements LCustomInfoService {
    @Autowired
    LCustomMapper lCustomMapper;

    @Override
    public LCustom findCustomByCid(int cid) {
        return lCustomMapper.selectCustomInfoByCid(cid);
    }

    @Override
    public List<LAdress> findAllAdress() {
        return lCustomMapper.selectAllAdress();
    }

    @Override
    public List<LAdress> findAllAdressByCid(int cid) {
        return lCustomMapper.selectCAdressByCid(cid);
    }

    @Override
    public void modifyCustomInfo(String cname,String phone,int cid) {
        lCustomMapper.updateInfo(cname,phone,cid);
    }

    @Override
    public void addAdress(LAdress adress) {
        lCustomMapper.addAdressByCid(adress);
    }

    @Override
    public void delAdress(int adressid) {
        lCustomMapper.deleteAdressByAdressid(adressid);
    }
//地址更新
    @Override
    public void updateAdrss(String ianme,String shphone,String address,int adressid) {
        lCustomMapper.updateAdressByAid(ianme,shphone,address,adressid);
    }
//密码变更
    @Override
    public void changePwdByCid(String newPwd, int cid) {
        lCustomMapper.changePassWord(newPwd,cid);
    }

    @Override
    public LAdress findeadress(int aid) {
        return lCustomMapper.selectAdressById(aid);
    }
}
