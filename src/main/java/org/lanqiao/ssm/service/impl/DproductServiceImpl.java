package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.DproductMapper;
import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dcategorys;
import org.lanqiao.ssm.pojo.Dproducts;
import org.lanqiao.ssm.service.DIproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DproductServiceImpl implements DIproductService {
    @Autowired
    DproductMapper dproductMapper;
    @Override
    public void insertProduct2(Dproducts dproducts) {
        dproductMapper.insertProduct(dproducts);
    }

    @Override
    public List<Dproducts> selectProductAll2(Condation condition) {
        System.out.println("===============++++++++++++++===="+condition);
        return dproductMapper.selectProductAll(condition);
    }

    @Override
    public int selectProductCount2(Condation condition) {
        System.out.println("==================="+condition);
        return dproductMapper.selectProductCount(condition);
    }

    @Override
    public void deleteProductById2(int pid) {
        dproductMapper.deleteProductById(pid);
    }

    @Override
    public void updateProductById2(Dproducts dproducts) {
        dproductMapper.updateProductById(dproducts);
    }

    @Override
    public Dproducts selectProductById2(int pid) {
        return dproductMapper.selectProductById(pid);
    }

    @Override
    public List<Dcategorys> findType2() {
        return dproductMapper.findType();
    }
}
