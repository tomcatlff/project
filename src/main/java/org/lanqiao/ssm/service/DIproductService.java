package org.lanqiao.ssm.service;




import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dcategorys;
import org.lanqiao.ssm.pojo.Dproducts;

import java.util.List;

public interface DIproductService {
    public void insertProduct2(Dproducts dproducts);

    public List<Dproducts> selectProductAll2(Condation condition);

    public int selectProductCount2(Condation condition);

    public void deleteProductById2(int pid);

    public void updateProductById2(Dproducts dproducts);

    public Dproducts selectProductById2(int pid);

    public List<Dcategorys> findType2();
}
