package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dcategorys;
import org.lanqiao.ssm.pojo.Dproducts;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Auther: WDS
 * @Date: 2019/1/11 15:41
 * @Description:
 */
@Mapper
@Component
public interface DproductMapper {
    //添加商品
    public void insertProduct(Dproducts dproducts);
    //查询
    public List<Dproducts> selectProductAll(Condation condition);
    //数量
    public int selectProductCount(Condation condition);
    //删除
    public void deleteProductById(int pid);
    //更新
    public void updateProductById(Dproducts dproducts);
    //通过id查找
    public Dproducts selectProductById(int pid);
    //查找类别
    public List<Dcategorys> findType();

}
