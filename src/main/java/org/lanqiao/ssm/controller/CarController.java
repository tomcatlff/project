package org.lanqiao.ssm.controller;


import org.lanqiao.ssm.pojo.Carts;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustomsOrders;
import org.lanqiao.ssm.service.ICartService;
import org.lanqiao.ssm.service.LCustomInfoService;
import org.lanqiao.ssm.service.LCustomOrdersService;
import org.lanqiao.ssm.service.LOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    ICartService cartService;
    @Autowired
    LCustomInfoService service;
    @Autowired
    LCustomOrdersService ordersService;
    @Autowired
    LOrderInfoService infoService;
    //添加到购物车
    @RequestMapping("/addCar")
    public void addCar(HttpServletRequest req, HttpServletResponse resp, Model model){
        String id = req.getParameter("pid");
        int pid = Integer.parseInt(id);
        System.out.println(pid);
        String pnum = req.getParameter("num");
        int num =Integer.parseInt(pnum);
        System.out.println(num);
        System.out.println("添加购物车");
        Boolean flag = false;
        List<Carts> cartList = cartService.findAll(1);
        for(Carts car:cartList){
            if (pid == car.getPid()) {
                car.setPnum(car.getPnum() + num);
                cartService.update(car);
                flag= true;
                break;
            }
        }
        if(flag==false){
            Carts carts = new Carts(1,pid,num);
            cartService.addcaritem(carts);
            System.out.println("添加成功");
        }


    }
    //显示购物车里面的东西
    @RequestMapping("/carList")
    public String carList(HttpServletRequest req, HttpServletResponse resp, Model model){
//        HttpSession session = req.getSession();
//        String uid = session.getAttribute("uid").toString();
//        int cid = Integer.parseInt(uid);
        List<Carts> cartList = cartService.findAll(1);
        Double money =0.0;
        for(Carts carts:cartList){
           int num =carts.getPnum();
           Double price =carts.getPprice();
           money+=num*price;
        }
        model.addAttribute("money",money);
        model.addAttribute("carList",cartList);
        return "cart";
    }
    //修改购物车数量加
    @GetMapping("/updateCar/{cartid}")
    public String updateCar(@PathVariable int cartid, HttpServletRequest req, HttpServletResponse resp){
        System.out.println("增加");
       Carts carts = cartService.cartimByNo(cartid);
        int num = carts.getPnum();
         num++;
         carts.setPnum(num);
        cartService.update(carts);
        return "redirect:/carList";
    }
    //修改购物车数量减
    @GetMapping("/updateCars/{cartid}")
    public String updateCars(@PathVariable int cartid, HttpServletRequest req, HttpServletResponse resp){
        System.out.println("减少");
        Carts carts = cartService.cartimByNo(cartid);
        int num = carts.getPnum();
        num--;
        carts.setPnum(num);
        cartService.update(carts);
        return "redirect:/carList";
    }
    //删除购物车中该商品
    @GetMapping("/deleteCar/{carid}")
    public String deleteCar(@PathVariable int carid, HttpServletRequest req, HttpServletResponse resp,Model model) throws ServletException, IOException {
        cartService.deletecartiem(carid);
        System.out.println(carid);
        return "redirect:/carList";
    }
    //清空购物车
    @RequestMapping("/deleteAll")
    public String deleteAll(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        int cid =Integer.parseInt(session.getAttribute("Cid").toString());
        cartService.deleteAll(cid);
        return "cart";

    }
    //结算
    @RequestMapping("/pay")
    public String payMoney(HttpServletRequest req, HttpServletResponse resp,Model model){
        List<Carts> cartList = cartService.findAll(1);
        Double money =0.0;
        for(Carts carts:cartList){
            int num =carts.getPnum();
            Double price =carts.getPprice();
            money+=num*price;
        }
        HttpSession session = req.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        List<LAdress> adressList=service.findAllAdressByCid(cid);
        model.addAttribute("money",money);
        model.addAttribute("carList",cartList);
        model.addAttribute("adressList",adressList);
        return "/payindex";
    }
    //生成订单
    @RequestMapping("/successIndex")
    public String paysuccessPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        int oidstr= 1;
        List<LCustomsOrders> ordersList = ordersService.findAllOrderByCid(cid);
        for (LCustomsOrders order :ordersList){
            if (order.getOid()>oidstr){
                oidstr = order.getOid();
            }
        }
        int oid = oidstr+1;
        int adressid= Integer.parseInt(request.getParameter("adressid"));
        LAdress adress = service.findeadress(adressid);
//        double pprice = Double.parseDouble(request.getParameter("ppriceStr"));
//        int pid = Integer.parseInt(request.getParameter("pidStr"));
//        int couts = Integer.parseInt(request.getParameter("counts"));
        List<Carts> cartList = cartService.findAll(1);
        Double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        Double money =0.0;
        int count=0;
        Date time = new Date();
        ordersService.addOrder(oid,cid,adressid,count,totalMoney,time);
        for(Carts carts:cartList){
            int num =carts.getPnum();
            int pid = carts.getPid();

            Double price =carts.getPprice();
            money+=num*price;
            count += num;
            ordersService.change(pid,num);

            infoService.addOrderInfo(oid,pid,num,price);
        }
        cartService.deleteAll(cid);
        model.addAttribute("adress",adress);
        model.addAttribute("price",money);
        model.addAttribute("oid",oid);


//        infoService.addOrderInfo(oid,pid,pprice);
        return "submitsuccess";
    }
}
