package org.lanqiao.ssm.service.impl;


import org.lanqiao.ssm.mapper.EvalProductMapper;
import org.lanqiao.ssm.pojo.EvalProduct;
import org.lanqiao.ssm.service.IEvalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvalProductServiceImpl implements IEvalProductService {
    @Autowired
    EvalProductMapper evalProductMapper;
    @Override
    public List<EvalProduct> findEvalProduct(int pid) {
        return evalProductMapper.getEvalProduct(pid);
    }

    @Override
    public void addEvalProduct(EvalProduct evalProduct) {
        evalProductMapper.addEvalProduct(evalProduct);
    }
}
