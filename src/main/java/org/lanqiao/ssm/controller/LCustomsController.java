package org.lanqiao.ssm.controller;

import org.apache.ibatis.annotations.Delete;
import org.lanqiao.ssm.pojo.LAdress;
import org.lanqiao.ssm.pojo.LCustom;
import org.lanqiao.ssm.service.LCustomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LCustomsController {
    @Autowired
    LCustomInfoService lCustomInfoService;
//    进入用户中心
    @RequestMapping("gotoUserCenter")
    public String getinCenter(){

        return "customcenter";
    }
//    获取用户信息
    @RequestMapping("customsinfo")
    public String userinfoPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        LCustom custom = lCustomInfoService.findCustomByCid(cid);
        List<LAdress> adressList = lCustomInfoService.findAllAdressByCid(cid);
        model.addAttribute("adressList",adressList);
        model.addAttribute("custom",custom);
        return "userinfocenter";
    }
//    更新用户信息
    @RequestMapping("customsinfoUp")
    public String customInfoUpdate(HttpServletRequest request){
        String cidStr = request.getParameter("cid");
        int cid= Integer.parseInt(cidStr);
        String cname=request.getParameter("cname");
        String phone=request.getParameter("phone");
//        System.out.println(cidStr+"----"+cname+"-=-=-="+phone);
        lCustomInfoService.modifyCustomInfo(cname,phone,cid);
        return "redirect:customsinfo";
    }
//    获取该用户所有地址
    @GetMapping("customAdressPage")
    public String customAdressPage(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        List<LAdress> adressList = lCustomInfoService.findAllAdressByCid(cid);
        model.addAttribute("adressList",adressList);
        return "useraddress";
    }
    //    添加地址
    @PostMapping("addAdress")
    public String  SaveAdress(HttpServletRequest request){
        List<LAdress> adressList = lCustomInfoService.findAllAdress();
        int adressidstr= 0;
        for (LAdress ad :adressList){
            if (ad.getAdressid()>adressidstr){
                adressidstr = ad.getAdressid();
            }
        }
        int adressid = adressidstr+1;
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        String shengfu = request.getParameter("sheng");
        String chengshi = request.getParameter("chengshi");
        String shiqu = request.getParameter("shiqu");

        String iname = request.getParameter("iname");
        String shphone = request.getParameter("shphone");
        String address = request.getParameter("address");
        String quyu = shengfu+"/"+chengshi+"/"+shiqu;

        int c_d = 0;
        LAdress adress = new LAdress(adressid,cid,iname,address,shphone,c_d,quyu);
        lCustomInfoService.addAdress(adress);
        return "redirect:/customAdressPage";
    }
//    删除地址
    @DeleteMapping("addAdress/{adressid}")
    public String deleteAdress(@PathVariable int adressid){
        System.out.println(adressid);
        lCustomInfoService.delAdress(adressid);
//        重定向时注意路径问题 是否添加/
        return "redirect:/customAdressPage";
    }
    @RequestMapping("updateAdress")
    public String updataAdress(HttpServletRequest request){
        int addressid = Integer.parseInt(request.getParameter("adressid"));
        String iname = request.getParameter("iname");
        String shphone = request.getParameter("shphone");
        String adress = request.getParameter("address");
        lCustomInfoService.updateAdrss(iname,shphone,adress,addressid);
        return "redirect:/customAdressPage";
    }
//    安全中心
    @RequestMapping("securityPage")
    public String anquanhzongx(){
        return "securitycnter";
    }
//    密码修改
    @RequestMapping("changePwd")
    public String ciugaimima(HttpServletRequest request){
        String nePwd = request.getParameter("newPassword");
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        lCustomInfoService.changePwdByCid(nePwd,cid);
//        下面写登陆页面的请求redirect:/
        return "redirect:/loginPage";
    }
    @RequestMapping("tuichuPge")
    public String tuichuP(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
//        返回登陆页面
        return "index";
    }
}
