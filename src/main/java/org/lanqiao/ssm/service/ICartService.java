package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.Carts;

import java.util.List;

public interface ICartService {
    public void addcaritem(Carts car);
    public void  deletecartiem(int cartid);
    public  Carts cartimByNo(int cartid);
    public void update(Carts car);
    public void deleteAll(int cid);

    List<Carts> findAll(int uid);
}
