package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.EvalProduct;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface EvalProductMapper {
    //根据产品id获取产品评论
    @Select("select c.cname,e.evaluate from evaluates e,customs c where e.cid=c.cid and e.passid=1 and e.pid=#{e.pid}")
    public List<EvalProduct> getEvalProduct(int pid);
    @Insert("insert into evaluates(cid,pid,evaluate,creatdate,passid) values(#{cid},#{pid},#{evaluate},#{creatdate},#{passid})")
    //添加评论
    public void addEvalProduct(EvalProduct evalProduct);

}
