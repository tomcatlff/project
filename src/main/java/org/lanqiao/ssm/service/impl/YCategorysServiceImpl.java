package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.YCategorysMapper;
import org.lanqiao.ssm.pojo.Categorys;
import org.lanqiao.ssm.service.IYCategorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YCategorysServiceImpl implements IYCategorysService {
    @Autowired
    YCategorysMapper yCategorysMapper;
    @Override
    public List<Categorys> getAll() {
        List<Categorys> categorysList = null;
        categorysList = yCategorysMapper.getAll();
        return categorysList;
    }
}
