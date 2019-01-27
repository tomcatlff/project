package org.lanqiao.ssm.service.impl;


import org.lanqiao.ssm.mapper.YLoginMapper;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;
import org.lanqiao.ssm.service.IYLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
//@CacheConfig(cacheNames = "empCache")
public class YLoginServiceImpl implements IYLoginService {
   @Autowired
    YLoginMapper yLoginMapper;

    @Override
//    @Cacheable(key = "targetClass + methodName")
    public List<Customs> findAll() {
        List<Customs> customsList = null;
        try {
            customsList =  yLoginMapper.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customsList;
    }

//    @Override
////    @CachePut(key = "targetClass + methodName + #p0")
//    public void insertUser(User user) {
//        try {
//            yLoginMapper.insertUser(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public Customs getuser(String cname) {

        return yLoginMapper.getuser(cname);
    }
}
