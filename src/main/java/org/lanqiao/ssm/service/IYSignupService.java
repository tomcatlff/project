package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;

import java.util.List;

public interface IYSignupService {
    public List<Customs> findAll();
    public void addUser(Customs customs);
//    public List<Customs> findAllCustoms();
}
