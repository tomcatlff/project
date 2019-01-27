package org.lanqiao.ssm.service;

import org.lanqiao.ssm.pojo.LWishList;

import java.util.List;

public interface LWishListSercice {
//    根据用户id查询其收藏夹
    public List<LWishList> findALLwishListByCid(int cid);
//    移除收藏的商品
    public void removeProdct(int pid, int cid);
    //    添加
    public void addWishList(int cid,int pid);
}
