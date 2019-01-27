package org.lanqiao.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.lanqiao.ssm.pojo.CusOrder;
import org.lanqiao.ssm.pojo.ProductEval;
import org.lanqiao.ssm.pojo.Wcustoms;
import org.lanqiao.ssm.pojo.WorderInfo;
import org.lanqiao.ssm.service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    ManagerServiceImpl managerService;

    //后台登录页面
    @RequestMapping("htloginPage")
    public String htloginPage(){
        return "htlogin";
    }

    //后台主页面
//    @RequestMapping("main")
//    public String houtaiPage(){
//        return "htindex";
//    }


    //个人中心
    @RequestMapping("admininfo")
    public String getAdminInfo(Model model){
//        Dadminstrators admin = managerService.findAdminById(1);
//        model.addAttribute("admin",admin);
        return "admin-info";
    }

//    //获取所有顾客的信息
//    @RequestMapping("/memberlist")
//    public String getCusInfo(Model model){
//        List<Wcustoms> customsList = managerService.findCusAll();
//        model.addAttribute("customsList",customsList);
//        return "member-list";
//    }

//    //顾客详细信息管理
//    @RequestMapping("memberinfo")
//    public String cusInfo(){
//        return "member-Info";
//    }

    //用户分页---获取顾客的信息
    @RequestMapping("memberPageList")
    public String cusPageList(Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        PageHelper.startPage(currentPageNum,5);//当前页，显示几条数据
        List<Wcustoms> customsList = managerService.findCusAll();//获取顾客list
        PageInfo<Wcustoms> pageInfo = new PageInfo<Wcustoms>(customsList);//封装
        model.addAttribute("customsList", customsList);
        model.addAttribute("pageInfo",pageInfo);
        return "member-list";
    }


    //根据id删除顾客
    @RequestMapping("deleteCus/{cid}")
    public void deleteCus(Model model, HttpServletRequest req, HttpServletResponse resp,@PathVariable int cid) throws ServletException, IOException {
        managerService.deleCus(cid);
        cusPageList(model,1);
        req.getRequestDispatcher("/memberPageList").forward(req,resp);
        //return "redirect:memberlist";
    }

    //根据id需改顾客的状态---禁用
    @RequestMapping("updateCusState/{cid}")
    public void updateCusState(@PathVariable int cid, Model model, HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        managerService.updateStateN(cid);
        cusPageList(model,1);
        req.getRequestDispatcher("/memberPageList").forward(req,resp);

    }

    //获取所有订单信息
    @RequestMapping("orderlist")
    public String getOrder(Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        PageHelper.startPage(currentPageNum,5);//当前页，显示几条数据
        List<CusOrder> orderList = managerService.findOrder();
        PageInfo<CusOrder> pageInfo = new PageInfo<CusOrder>(orderList);//
        model.addAttribute("orderList",orderList);
        model.addAttribute("pageInfo",pageInfo);
        return "order-list";
    }

    //根据id修改订单货物的状态
    @RequestMapping("updatebstate/{oid}")
    public String updateBstateByid(Model model, HttpServletRequest req, HttpServletResponse resp,@PathVariable int oid,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum) throws ServletException, IOException {
        managerService.modifyBstate(oid);
        getOrder(model,currentPageNum);
        return "order-list";
        //req.getRequestDispatcher("orderlist").forward(req,resp);
    }

    //根据id获取订单详情
    @RequestMapping("orderinfo/{oid}")
    public String getOrderInfo(@PathVariable int oid,Model model,HttpServletRequest req, HttpServletResponse resp){
        List<WorderInfo> orderInfoList = managerService.findOrderInfo(oid);
        model.addAttribute("orderInfoList", orderInfoList);
        return "order-Info";
    }


    //搜索---根据订单编号查询订单
    @RequestMapping("searchOrder")
    public String searchOrder(Model model,HttpServletRequest req, HttpServletResponse resp,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        //PageHelper.startPage(currentPageNum,1);//当前页，显示几条数据
        String oidStr = req.getParameter("orderoid");
        int oid = Integer.parseInt(oidStr);
        List<CusOrder> orderList = managerService.findOrderByOid(oid);
        //PageInfo<CusOrder> pageInfo = new PageInfo<CusOrder>(orderList);//
        model.addAttribute("orderList",orderList);
        //model.addAttribute("pageInfo",pageInfo);
        //return "order-list";
        return "search-order";
    }

    //评论管理
    @RequestMapping("/evalmanager")
    public String getProductEval(Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        PageHelper.startPage(currentPageNum,5);//当前页，显示几条数据
        List<ProductEval> evalList = managerService.findProductEval();
        PageInfo<ProductEval> pageInfo = new PageInfo<ProductEval>(evalList);//
        model.addAttribute("evalList",evalList);
        model.addAttribute("pageInfo",pageInfo);
        return "productEval-list";
    }


    //评论审核---根据评论的内容---通过
    @RequestMapping("modifyEvalStateY/{eid}")
    public String modifyEvalStateY(@PathVariable int eid,Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        managerService.updateProdEvalY(eid);
        getProductEval(model,currentPageNum);
        return "productEval-list";
    }

    //评论审核---根据评论的内容---不通过
    @RequestMapping("modifyEvalStateN/{eid}")
    public String modifyEvalStateN(@PathVariable int eid,Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        managerService.updateProdEvalN(eid);
        getProductEval(model,currentPageNum);
        return "productEval-list";
    }














//    @RequestMapping("adminlist")
//    public String getManagerInfo(Model model){
////        List<Wcustoms> customsList = managerService.findCusAll();
////        model.addAttribute("customsList",customsList);
//        return "admin-list";
//    }
//
//    //三级联动
//    @RequestMapping("city")
//    public String city(){
//        return "city";
//    }


}
