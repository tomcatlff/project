package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustomsOrders;
import org.lanqiao.ssm.pojo.LOrderInfo;
import org.lanqiao.ssm.pojo.LProducts;
import org.lanqiao.ssm.service.LCustomOrdersService;
import org.lanqiao.ssm.service.LOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LOrderController {
    @Autowired
    LCustomOrdersService lCustomOrdersService;
    @Autowired
    LOrderInfoService lOrderInfoService;
//    展示所有订单
    @RequestMapping("showOrders")
    public String LorderList(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        List<LCustomsOrders> lCustomsOrdersList=lCustomOrdersService.findAllOrderByCid(cid);
        model.addAttribute("lCustomsOrdersList",lCustomsOrdersList);
        return "userorderlist";
    }
//    更新订单状态
    @GetMapping("updataBstate/{oid}")
    public String modifyOrderBsata(@PathVariable int oid){
        lCustomOrdersService.updataBstateid(oid);
        return "redirect:/showOrders";
    }
    @RequestMapping("showOrderInfoBy/{adressid}/{oid}")
    public String LorderInfo(@PathVariable int adressid,@PathVariable int oid,Model model){
        LCustomsOrders order = lCustomOrdersService.getOrederStateByOid(oid);
        LAdress adress = lOrderInfoService.findAdressById(adressid);
        List<LProducts> productsList = lOrderInfoService.findAllProsByOid(oid);
        model.addAttribute("order",order);
        model.addAttribute("adress",adress);
        model.addAttribute("productsList",productsList);
        return "userorderinfo";
    }
    @RequestMapping("quxiaoOrder/{oid}")
    public String quxiaoOrder(@PathVariable int oid){
        lCustomOrdersService.quxiaoOrderByOid(oid);
//        System.out.println(oid);
        return "qxorder";
    }
}
