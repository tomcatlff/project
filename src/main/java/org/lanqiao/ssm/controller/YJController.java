package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.Customs;
import org.lanqiao.ssm.pojo.Jproducts;
import org.lanqiao.ssm.service.ICustomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class YJController {
    @Autowired
    ICustomsService iCustomsService;
    @RequestMapping("queryAll")
    public String queryAll(Model model){
        List<Customs> customsList = iCustomsService.findAll();
        model.addAttribute("customsList",customsList);
        return "customslist";
    }

    //通过商品名称查询商品
    @RequestMapping("searchProduct")
    public String selectProduct(Model model, HttpServletRequest req, HttpServletResponse resp){
        String  prodname1 = req.getParameter("pname");
        String prodname2="%"+prodname1+"%";
        List<Jproducts> jproducts = iCustomsService.fingGoodsByPname(prodname2);
        System.out.println(jproducts);
        model.addAttribute("product",jproducts);
        return "query";
    }
    //通过价格区间查询商品信息
    @RequestMapping("selectPpriceY")
    public  String selectPprice(Model model, HttpServletRequest req, HttpServletResponse resp){
        Double  price1=Double.parseDouble(req.getParameter("price1"));
        Double  price2=Double.parseDouble(req.getParameter("price2"));
        List<Jproducts> jproductsList=iCustomsService.fingGoodsByPcounts(price1,price2);
        model.addAttribute("jproductsList",jproductsList);
        return "query";
    }

    @RequestMapping("queryPage")
    public  String querypage(){return "query";}


}
