package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustomsOrders;
import org.lanqiao.ssm.service.LCustomInfoService;
import org.lanqiao.ssm.service.LCustomOrdersService;
import org.lanqiao.ssm.service.LOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class successPyController {
    @Autowired
    LCustomOrdersService ordersService;
    @Autowired
    LCustomInfoService lCustomInfoService;
    @Autowired
    LOrderInfoService infoService;
    @RequestMapping("paysuccessIndex")
    public String paysuccessPage(HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//        String cidStr = session.getAttribute("Cid").toString();
//        int cid = Integer.parseInt(cidStr);
////        int cid = 1;
//        int oidstr= 1;
//        List<LCustomsOrders> ordersList = ordersService.findAllOrderByCid(cid);
//        for (LCustomsOrders order :ordersList){
//            if (order.getOid()>oidstr){
//                oidstr = order.getOid();
//            }
//        }
//        int oid = oidstr+1;
//        int adressid= Integer.parseInt(request.getParameter("adressid"));
//        LAdress adress = lCustomInfoService.findeadress(adressid);
//        double pprice = Double.parseDouble(request.getParameter("ppriceStr"));
//        int pid = Integer.parseInt(request.getParameter("pidStr"));
//        int couts = Integer.parseInt(request.getParameter("counts"));
//        model.addAttribute("adress",adress);
//        model.addAttribute("price",pprice);
//        model.addAttribute("oid",oid);
//        Date time = new Date();
//        ordersService.addOrder(oid,cid,adressid,couts,pprice,time);
//        String ppriceStr = request.getParameter("ppriceStr");
//        infoService.addOrderInfo(oid,pid,couts,pprice);
////        return "paysuccess";

        String pprice = request.getParameter("price");
        String oid = request.getParameter("oid");
        String iname = request.getParameter("iname");
        String shphone = request.getParameter("shphone");
        String address = request.getParameter("address");
        String quyu = request.getParameter("quyu");
//        String pid = request.getParameter("pid");

//        System.out.println(address+"--"+pprice+"--"+"--"+oid+"--"+iname+"--"+shphone+"--"+quyu+"-=-=-="+pid);

        model.addAttribute("price",pprice);
        model.addAttribute("oid",oid);
        model.addAttribute("iname",iname);
        model.addAttribute("shphone",shphone);
        model.addAttribute("address",address);
        model.addAttribute("quyu",quyu);

        return "paysuccess";
    }
}
