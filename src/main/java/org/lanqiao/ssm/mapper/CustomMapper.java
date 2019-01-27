package org.lanqiao.ssm.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.Jproducts;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface CustomMapper {
    @Select("select * from customs")
    public List<Customs> selectAll();
    @Select("select * from customs where cid=#{cid}")
    public Customs selectCustomsById(int cid);

    //根据商品名称搜索商品信息
    @Select("select * from products,protype where products.pid=protype.pid and protype.moren = 1 and Pname like #{Pname}")
    public List<Jproducts>  selectGoodsByPname(String Pname);


    //根据价格区间查询商品信息
    @Select("select * from products,protype where products.pid=protype.pid and protype.moren = 1 and Pprice BETWEEN #{Pprice} and #{Pprice1};")
    public List<Jproducts>  selectGoodsByPcounts(@Param("Pprice") Double Pprice, @Param("Pprice1") Double Pprice1);
}

