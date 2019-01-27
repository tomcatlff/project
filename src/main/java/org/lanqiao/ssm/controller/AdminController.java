package org.lanqiao.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.ssm.pojo.Condation;
import org.lanqiao.ssm.pojo.Dadminstrators;
import org.lanqiao.ssm.service.impl.AdminServiceImpl;
import org.lanqiao.ssm.utils.MD5Utils;
import org.lanqiao.ssm.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminServiceImpl adminService;
    @RequestMapping("/adminList")
    //全部
    public String adminAll(HttpServletRequest req, HttpServletResponse resp, Model model,@RequestParam(required = false,defaultValue = "1",value = "currentPageNum")int currentPageNum){
        PageHelper.startPage(currentPageNum,5);
        //查询条件
        String searchName="";
        if(req.getParameter("searchName")!=null){
            searchName=req.getParameter("searchName");
        }
        Condation condation = new Condation(searchName);
        List<Dadminstrators> adminList = adminService.selectAdminAll2(condation);
        PageInfo<Dadminstrators> pageInfo = new PageInfo(adminList);
        model.addAttribute("adminList",adminList);
        model.addAttribute("condation",condation);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-list";
    }

    //删除
    @RequestMapping("/deleteAdmin")
    public @ResponseBody String deleteProduct(@RequestParam(value = "aid[]") int[] aid, HttpServletRequest req, HttpServletResponse resp, Model model){
        String method = req.getParameter("method");
        for(int i:aid){
           adminService.deleteAdmintById2(i);
        }
        return adminAll(req, resp, model,1);
    }

    //跳转到添加页面
    @RequestMapping("/adminadd")
    public String addIndex(){
        System.out.println("页面跳转");
        return "admin-add";
    }

    //跳转到修改页面
    @GetMapping("/updateAdmin")
    public String updateIndex(HttpServletRequest req, HttpServletResponse resp, Model model){
        System.out.println("页面跳转");
        HttpSession session = req.getSession();
        String aid = session.getAttribute("aid").toString();
        int id = Integer.parseInt(aid);
        Dadminstrators admin = adminService.selectAdminById2(id);
        String apassword = admin.getApassword();//获得密码
        String pass = MD5Utils.convertMD5(apassword);//解密
        model.addAttribute("admin",admin);
        model.addAttribute("pass",pass);
        return "admin-edit";
    }

    //跳转到修改密码页面
    @GetMapping("/updatePass")
    public String updatePass(HttpServletRequest req, HttpServletResponse resp,Model model){
        HttpSession session = req.getSession();
       String aid = session.getAttribute("aid").toString();
        int id = Integer.parseInt(aid);
        Dadminstrators admin = adminService.selectAdminById2(id);
        String apassword = admin.getApassword();//获得密码
        String pass = MD5Utils.convertMD5(apassword);//解密
        model.addAttribute("admin",admin);
        model.addAttribute("pass",pass);
        return "admin-pass";
    }

    //修改
    @RequestMapping("/addAdmin")
    public String addProduct(HttpServletRequest req, HttpServletResponse resp,Model model) throws ParseException, ServletException, IOException {
        System.out.println("添加商品");
        String aname=req.getParameter("aname");
        String aphone = req.getParameter("aphone");
        String apassword=req.getParameter("apassword");
        String password= MD5Utils.convertMD5(apassword);
        String email = req.getParameter("aemail");
        String address = req.getParameter("aaddress");
        String method = req.getParameter("method");
        int aid=0;
        if(("update").equals(method)){
            aid=Integer.parseInt(req.getParameter("aid"));
            Dadminstrators dadminstrators = new Dadminstrators(aid,aname,aphone,password,email,address);
            adminService.updateAdminById2(dadminstrators);
            updateIndex(req,resp,model);
            return "admin-edit";
        }else{
            aid=adminService.selectAdminCount2()+1;
            Dadminstrators dadminstrators = new Dadminstrators(aid,aname,aphone,password,email,address);
            adminService.insertAdmin2(dadminstrators);
            login(req,resp,model);
            return "redirect:/";
       }
    }

    //注册
    @RequestMapping("zhuce")
    public void zhuceye(HttpServletRequest req,HttpServletResponse resp,Model model) throws ServletException, IOException {
        System.out.println("添加商品");
        String aname=req.getParameter("aname");
        String aphone = req.getParameter("aphone");
        String apassword=req.getParameter("apassword");
        String password= MD5Utils.convertMD5(apassword);
        String email = req.getParameter("aemail");
        String province  = req.getParameter("province");
        String city = req.getParameter("city");
        String area = req.getParameter("area");
        String address = province+city+area;
        String method = req.getParameter("method");
        int aid=adminService.selectAdminCount2()+1;
        Dadminstrators dadminstrators = new Dadminstrators(aid,aname,aphone,password,email,address);
        adminService.insertAdmin2(dadminstrators);
        adminAll(req,resp,model,1);
        req.getRequestDispatcher("/adminList").forward(req,resp);
        //return "htlogin";
    }

    //登陆验证
    @RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp,Model model){
        String username=req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String rcode = req.getParameter("rcode");
        String s =(String)req.getSession().getAttribute("rcode");
        List<Dadminstrators> adminList = adminService.selectAdminAll2();
        System.out.println(adminList);
        Boolean flag =false;
        String result="";
        for (Dadminstrators adminstrator:adminList){
            if((username.trim()).equals(adminstrator.getAname())){
                flag = true;
            }
        }
        if(flag){
            Dadminstrators admin= adminService.selectAdminByName(username);
            String mpass =admin.getApassword(); //数据库获得密码
            String plaintext = MD5Utils.convertMD5(mpass);//解密
            if((password.trim()).equals(plaintext)){
                if(s.equals(rcode)){
                    int aid = admin.getAid();
                    HttpSession session = req.getSession();
                    session.setAttribute("username",username);
                    session.setAttribute("aid",aid);
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    resp.addCookie(cookie);
//                    model.addAttribute("msg","登陆成功！");
                    result = "htindex";
                }else {
                    model.addAttribute("msg","验证码错误");
                    result = "htlogin";
                }
            }else {
                model.addAttribute("msg","密码错误");
                result ="htlogin";
            }

        }else {
            model.addAttribute("msg","用户不存在,请核对信息再登陆");
            result ="htlogin";
        }

    return result;
    }
    //生成验证码
    @RequestMapping("/imageCode")
    public void verifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc  = new VerifyCode();
        BufferedImage bi = vc.getImage();
        String rcode = vc.getText();
        rcode = rcode.toLowerCase();
        HttpSession s = req.getSession();
        s.setAttribute("rcode",rcode);
        VerifyCode.output(bi,resp.getOutputStream());
    }

}
