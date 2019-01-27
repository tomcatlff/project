package org.lanqiao.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.ssm.pojo.Dproducts;
import org.lanqiao.ssm.pojo.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YProductsMapper {
//    查询全部商品，分五类写的，由于主页的分类是死的
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid=1")
    public List<Products> getinfo1();
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid=2")
    public List<Products> getinfo2();
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid=3")
    public List<Products> getinfo3();
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid=4")
    public List<Products> getinfo4();
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid=5")
    public List<Products> getinfo5();

//    按商品id查询商品信息
    @Select("select pro.pid,pro.typeid,pro.pname,pro.pprice,pro.pinfo,prt.pimg,cat.categorysname from products pro,protype prt,categorys cat where pro.pid=prt.pid and prt.moren = 1 and pro.typeid = cat.typeid and pro.pid = #{pid}")
    public Products selectProductsById(int pid);
    //按类别查询


    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 and pro.typeid = #{typeid} and pro.pid != #{pid} limit 0,4")
    public List<Products> products(@Param("typeid") int typeid,@Param("pid") int pid);
    //更多查询
    @Select("select pro.pid,pro.pname,pro.pprice,prt.pimg from products pro,protype prt where pro.pid = prt.pid and prt.moren = 1 order by rktime desc limit 0,4")
    public List<Products> moreProduct();
    //根据pid查询图片
    @Select("select pro.pid,pro.typeid,pro.pname,pro.pprice,pro.pinfo,prt.pimg,cat.categorysname from products pro,protype prt,categorys cat where pro.pid=prt.pid and prt.moren = 0 and pro.typeid = cat.typeid and pro.pid = #{pid}")
    public List<Products> sameProduct(int pid);

}
