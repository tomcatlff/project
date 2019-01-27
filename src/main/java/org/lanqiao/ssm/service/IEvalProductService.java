package org.lanqiao.ssm.service;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.EvalProduct;

import java.util.List;

public interface IEvalProductService {
    //根据产品id获取产品评论
    public List<EvalProduct> findEvalProduct(int pid);
    //添加评论
    public void addEvalProduct(EvalProduct evalProduct);
}
