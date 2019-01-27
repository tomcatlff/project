package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LProducts;
import org.lanqiao.ssm.pojo.Products;
import org.lanqiao.ssm.service.IYProductsService;
import org.lanqiao.ssm.service.LCustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LlijiPayController {
    @Autowired
    LCustomInfoService service;
    @Autowired
    IYProductsService productsService;
    @RequestMapping("msPay/{pid}")
    public String lijigoumia(@PathVariable int pid, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
//        int cid = 1;
        List<LAdress> adressList=service.findAllAdressByCid(cid);
        Products product = productsService.selectProductsById(pid);
//        System.out.println(product);
        model.addAttribute("product",product);
        model.addAttribute("adressList",adressList);
        return "lijipayindex";

    }


}
