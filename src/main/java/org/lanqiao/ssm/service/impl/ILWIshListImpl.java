package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.LWishListMapper;
import org.lanqiao.ssm.pojo.LWishList;
import org.lanqiao.ssm.service.LWishListSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ILWIshListImpl implements LWishListSercice {
    @Autowired
    LWishListMapper lWishListMapper;
    @Override
    public List<LWishList> findALLwishListByCid(int cid) {
        return lWishListMapper.selectAllWishByCid(cid);
    }

    @Override
    public void removeProdct(int pid,int cid) {
        lWishListMapper.deleteWishListByPid(pid,cid);
    }

    @Override
    public void addWishList(int cid, int pid) {
        lWishListMapper.InsertWishList(cid, pid);
    }
}
