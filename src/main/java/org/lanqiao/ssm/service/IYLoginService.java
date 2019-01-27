package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.User;
import java.util.List;

public interface IYLoginService {
    public List<Customs> findAll();
    public Customs getuser(String cname);
}
