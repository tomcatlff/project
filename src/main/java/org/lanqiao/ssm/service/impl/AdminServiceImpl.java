package org.lanqiao.ssm.service.impl;



import org.lanqiao.ssm.mapper.DadminMapper;
import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dadminstrators;
import org.lanqiao.ssm.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    DadminMapper adminMapper;
    @Override
    public void insertAdmin2(Dadminstrators dadminstrators) {
        adminMapper.insertAdmin(dadminstrators);
    }

    @Override
    public List<Dadminstrators> selectAdminAll2(Condation condation) {
        return adminMapper.selectAdminAll(condation);
    }

    @Override
    public int selectAdminCount2() {
        return adminMapper.selectAdminCount();
    }

    @Override
    public void deleteAdmintById2(int aid) {
        adminMapper.deleteAdmintById(aid);
    }

    @Override
    public void updateAdminById2(Dadminstrators dadminstrators) {
        adminMapper.updateAdminById(dadminstrators);
    }

    @Override
    public Dadminstrators selectAdminById2(int aid) {
        return adminMapper.selectAdminById(aid);
    }

    @Override
    public Dadminstrators selectAdminByName(String name) {
        return adminMapper.selectAdminByName(name);
    }

    @Override
    public List<Dadminstrators> selectAdminAll2() {
        return adminMapper.selectAdminAll();
    }
}
