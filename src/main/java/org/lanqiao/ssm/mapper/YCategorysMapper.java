package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.Categorys;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YCategorysMapper {
    @Select("select * from categorys")
    public List<Categorys> getAll();
}
