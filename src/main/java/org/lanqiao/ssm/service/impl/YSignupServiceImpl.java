package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.YSignupMapper;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;
import org.lanqiao.ssm.service.IYSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class YSignupServiceImpl implements IYSignupService {

    @Autowired
    YSignupMapper ySignupMapper;

    @Override
    public List<Customs> findAll() {
        List<Customs> customsList = null;
        try {
            customsList =  ySignupMapper.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customsList;
    }

    @Override
    public void addUser(Customs customs) {
        try {
            ySignupMapper.addUser(customs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public List<Customs> findAllCustoms() {
//        return ySignupMapper.selectAllCustoms();
//    }
}
