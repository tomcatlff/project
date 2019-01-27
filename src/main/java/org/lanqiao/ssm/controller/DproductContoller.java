package org.lanqiao.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dcategorys;
import org.lanqiao.ssm.pojo.Dproducts;
import org.lanqiao.ssm.service.impl.DproductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DproductContoller {
    @Autowired
    DproductServiceImpl productService;
    //获取所有商品的信息
    @RequestMapping("/productList")
    public String productAll(@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum,Model model,HttpServletRequest req, HttpServletResponse resp){
        PageHelper.startPage(currentPageNum,5);//当前页，显示几条数据
        //查询条件
        String searchDate="";
        if(req.getParameter("serDate")!=null){
            searchDate=req.getParameter("serDate");
        }
        String searchName="";
        if(req.getParameter("sername")!=null){
            searchName=req.getParameter("sername");
        }
        String searchType="-1";
        if(req.getParameter("sertype")!=null){
            searchType=req.getParameter("sertype");
        }
        Condation condation = new Condation();
        condation.setPname(searchName);
        condation.setTypeid(searchType);
        condation.setRktime(searchDate);
        List<Dproducts> productList = productService.selectProductAll2(condation);
        PageInfo<Dproducts> pageInfo = new PageInfo<Dproducts>(productList);//封装
        List<Dcategorys> typeList=productService.findType2();
       model.addAttribute("typeList",typeList);
        model.addAttribute("productList",productList);
        model.addAttribute("pageInfo",pageInfo);
        return "product-list";

    }

    //选择删除
    @GetMapping("/deleteProducts/{pid}")
    public  String deleteProduct(@RequestParam(value = "pid[]") int[] pid, HttpServletRequest req, HttpServletResponse resp, Model model) throws ServletException, IOException {
        String method = req.getParameter("method");
        for(int i:pid){
            productService.deleteProductById2(i);
        }
        System.out.println("删除数据");

//        req.getRequestDispatcher("/productList").forward(req,resp);
        return "redirect:/productList";
    }
    //删除单个
    @GetMapping("/deleteProduct/{pid}")
    public void deleteProducts(@PathVariable String pid, HttpServletRequest req, HttpServletResponse resp, Model model) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(pid);
        int id = Integer.parseInt(pid);

            productService.deleteProductById2(id);

        System.out.println("删除数据");

        req.getRequestDispatcher("/productList").forward(req,resp);

//        return "redirect:productList";
    }
    //跳转到添加页面
    @RequestMapping("/productadd")
    public String addIndex(Model model){
//        System.out.println("页面跳转");
        List<Dcategorys> typeList=productService.findType2();
        model.addAttribute("typeList",typeList);
        return "product-add";
    }
    //跳转到修改页面
    @GetMapping("/updateProduct/{pid}")
    public String updateIndex(@PathVariable int pid, Model model){
//        System.out.println("页面跳转");
        List<Dcategorys> typeList=productService.findType2();
        model.addAttribute("typeList",typeList);
       Dproducts dproducts = productService.selectProductById2(pid);
       model.addAttribute("products",dproducts);
       return "product-edit";
    }

    //添加/修改
    @RequestMapping("/addProduct")
    public String addProduct(HttpServletRequest req, HttpServletResponse resp,Model model) throws ParseException, ServletException, IOException {
        //System.out.println("添加商品");
        String pname=req.getParameter("pname");
        String pinfo = req.getParameter("pinfo");
        String type=req.getParameter("typeid");
        int typeid = Integer.parseInt(type);
        String pprice=req.getParameter("pprice");
        Double price = Double.parseDouble(pprice);
        String disprice=req.getParameter("disprice");
        Double diprice = Double.parseDouble(disprice);
        String pcount=req.getParameter("pcount");
        int count = Integer.parseInt(pcount);
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       String rktime=sdf.format(time);
        String method = req.getParameter("method");
        int pid=0;
        if(("update").equals(method)){
            pid=Integer.parseInt(req.getParameter("pid"));
            int redu = Integer.parseInt(req.getParameter("redu"));
            Dproducts dproducts = new Dproducts(pid,pname,pinfo,typeid,price,diprice,count,rktime,redu,1);
            productService.updateProductById2(dproducts);
        }else{
            Condation condation = new Condation("-1","",null);
            pid=productService.selectProductCount2(condation)+1;
            Dproducts dproducts = new Dproducts(pid,pname,pinfo,typeid,price,diprice,count,rktime,0,1);
            productService.insertProduct2(dproducts);
        }

        return productAll(7,model,req,resp);
    }

}
