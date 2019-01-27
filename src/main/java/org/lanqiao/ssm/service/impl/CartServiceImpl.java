package org.lanqiao.ssm.service.impl;

import org.lanqiao.ssm.mapper.DCartMapper;
import org.lanqiao.ssm.pojo.Carts;
import org.lanqiao.ssm.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    DCartMapper cartMapper;


    @Override
    public void addcaritem(Carts car) {
        cartMapper.addcar(car);
    }

    @Override
    public void deletecartiem(int cartid) {
        cartMapper.deletecar(cartid);
    }

    @Override
    public Carts cartimByNo(int cartid) {
        return cartMapper.cartimByNo(cartid);
    }

    @Override
    public void update(Carts car) {
        cartMapper.update(car);
    }

    @Override
    public void deleteAll(int cid) {
        cartMapper.deleteAll(cid);
    }

    @Override
    public List<Carts> findAll(int cid) {
        return cartMapper.cartList(cid);
    }
}
