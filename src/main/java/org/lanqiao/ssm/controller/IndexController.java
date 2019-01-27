package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.*;
import org.lanqiao.ssm.service.*;
import org.lanqiao.ssm.service.impl.EvalProductServiceImpl;
import org.lanqiao.ssm.service.impl.YSignupServiceImpl;
import org.lanqiao.ssm.utils.MD5Utils;
import org.lanqiao.ssm.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    private static final Object CinemaConstants = null;

    @RequestMapping("indexPage")
    public String TestIndex(){
        return "index" ;
    }

    @Autowired
    IYLoginService loginService;
    @Autowired
    ICartService cartService;
    @Autowired
    EvalProductServiceImpl evalProductService;
    @Autowired
    LCustomOrdersService ordersService;
    @Autowired
    LOrderInfoService infoService;
    @RequestMapping("loginPage")
    public String loginPageTest(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String cname = request.getParameter("cname");
        if(cname == null){
           return "login";
        }
        String cpassword = request.getParameter("cpassword");
        String rcode = request.getParameter("rcode");
        String s = (String) request.getSession().getAttribute("rcode");
        List<Customs> customsList = null;
        Customs customs = null;
        Boolean flag = false;
        customsList = loginService.findAll();
        String msg = "";
        for (Customs customs1 : customsList) {
            if ((cname.trim()).equals(customs1.getCname())) {
                flag = true;
            }
        }
        if (flag) {
            customs = loginService.getuser(cname);
            String cpassword1 = customs.getCpassword(); //数据库获得密码
            String plaintext = MD5Utils.convertMD5(cpassword1);//解密
            if ((cpassword.trim()).equals(cpassword1)) {
//            if ((cpassword.trim()).equals(plaintext)) {
                if (s.equals(rcode)) {
                    String name = customs.getCname();
                    int Cid = customs.getCid();
                    HttpSession session = request.getSession();
                    session.setAttribute("name",name);
                    session.setAttribute("Cid",Cid);
                    model.addAttribute("name",name);
                    model.addAttribute("Cid",Cid);
                    Cookie cookie = new Cookie("JSESSIONID",session.getId());
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    response.addCookie(cookie);
                    return "redirect:/shopPage";
                } else {
                    msg = "验证码错误!";
                }
            } else {
                msg = "密码错误!";
            }
        } else {
            msg = "用户不存在!";
        }
        model.addAttribute("msg",msg);
        return "login";
    }

    @RequestMapping("imageCodePage")
    public void imageCodePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCode vc  = new VerifyCode();
        BufferedImage bi = vc.getImage();
        String rcode = vc.getText();
        rcode = rcode.toLowerCase();
        HttpSession s = request.getSession();
        s.setAttribute("rcode",rcode);
        VerifyCode.output(bi,response.getOutputStream());
    }

    @Autowired
    YSignupServiceImpl ySignupService;
    @RequestMapping("signupPage")
    public String signupPage(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        if(request.getParameter("cname") == null){
            return "sign-up";
        }
        String msg ="";
        String cname = request.getParameter("cname");
        if("".equals(cname)){
            msg = "用户名不能为空！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }else if(cname.length() < 3){
            msg = "用户名不符合规范，请重新输入！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }
        String cpassword = request.getParameter("cpassword");
        if("".equals(cpassword)){
            msg = "密码不能为空！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }else if(cpassword.length() < 3){
            msg = "密码太短不安全，请重新设置！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }
        String phone = request.getParameter("phone");
        if("".equals(phone)){
            msg = "电话号不能为空！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }else if(phone.length() < 11){
            msg = "请输入正确的电话号码！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }

//                String ciphertext= MD5Utils.convertMD5(cpassword);

        Boolean flag = true;

        List<Customs> customsList = ySignupService.findAll();

        int customsidstr= 0;
        for (Customs cs :customsList){
            if (cs.getCid() > customsidstr){
                customsidstr = cs.getCid();
            }
        }
        int customscid = customsidstr+1;


        for (Customs customs:customsList){
            if(customs.getCname().equals(cname)){
                flag = false;
            }
        }
        if(flag){
            Customs customs = new Customs();
            customs.setCname(cname);
//                    customs.setCpassword(ciphertext);
            customs.setCpassword(cpassword);
            customs.setPhone(phone);
            customs.setCid(customscid);
            ySignupService.addUser(customs);
            return "redirect:/loginPage";
        }else {
            msg = "您已注册！";
            model.addAttribute("msg",msg);
            return "sign-up";
        }

    }

    @RequestMapping("forgotPage")
    public String forgotPage(){
        return "forgot";
    }


    @Autowired
    IYProductsService iyProductsService;
    @RequestMapping("shopPage")
    public String shopPage(Model model,HttpServletRequest request){
            HttpSession session = request.getSession();
//            String cidStr = session.getAttribute("Cid").toString();
//            int cid = Integer.parseInt(cidStr);
            int cid=0;
            if (session.getAttribute("Cid")!=null){
                String cidStr = session.getAttribute("Cid").toString();
                cid = Integer.parseInt(cidStr);
                List<Carts> cartList = cartService.findAll(cid);
                model.addAttribute("carList",cartList);
            }

        List<Products> productsList1 = iyProductsService.getinfo1();
        List<Products> productsList2 = iyProductsService.getinfo2();
        List<Products> productsList3 = iyProductsService.getinfo3();
        List<Products> productsList4 = iyProductsService.getinfo4();
        List<Products> productsList5 = iyProductsService.getinfo5();
        model.addAttribute("productsList1",productsList1);
        model.addAttribute("productsList2",productsList2);
        model.addAttribute("productsList3",productsList3);
        model.addAttribute("productsList4",productsList4);
        model.addAttribute("productsList5",productsList5);

        return "shop";
    }


    @RequestMapping("cartPage")
    public String cartPage(){
        return "cart";
    }


    @Autowired
    LWishListSercice lWishListSercice;
    @RequestMapping("productPage/{pid}")
    public String productPage( @PathVariable int pid,Model model,HttpServletRequest request){
        Products products = iyProductsService.selectProductsById(pid);

        HttpSession session = request.getSession();
        int cid=0;
        if (session.getAttribute("Cid")!=null){
            Boolean flag = false;
            String cidStr = session.getAttribute("Cid").toString();
            cid = Integer.parseInt(cidStr);
            List<LWishList> wishList = lWishListSercice.findALLwishListByCid(cid);
            for (LWishList wish:wishList){
                if (wish.getPid()==pid){
//                    System.out.println(pid+"=-=-=-"+wish.getPid());
                    flag=true;
                }
            }
//            System.out.println(flag);
            model.addAttribute("flag",flag);
        }

        int typeid = products.getTypeid();
        List<Products> similarList = iyProductsService.products(typeid,pid);
        List<Products> moreList = iyProductsService.moreProduct();
        List<Products> sameList = iyProductsService.sameProduct(pid);
                    List<Carts> cartList = cartService.findAll(cid);
        List<EvalProduct> evalProductList = evalProductService.findEvalProduct(pid);
        List<LCustomsOrders> ordersList = ordersService.findAllOrderByCid(cid);
        boolean flags = false;
        outterLoop:for(LCustomsOrders order:ordersList){
            //根据订单id获取到商品列表
            List<LProducts> productsList=infoService.findAllProsByOid(order.getOid()) ;
            for(LProducts product:productsList){
                if(pid==(product.getPid())){
                    flags = true;
                    break outterLoop;
                }
            }
        }
        model.addAttribute("flags",flags);
                    model.addAttribute("carList",cartList);
        model.addAttribute("similarList",similarList);
        model.addAttribute("moreList",moreList);
        model.addAttribute("sameList",sameList);
        model.addAttribute("evalProductList",evalProductList);



        model.addAttribute("products",products);
        return "product";
    }

    //添加评论
    @RequestMapping("/addEval/{pid}")
    public String addEval(@PathVariable int pid,Model model,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        String msg = req.getParameter("msg");
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String creatime=sdf.format(time);
        EvalProduct evalProduct = new EvalProduct(pid,cid,msg,creatime,0);
        evalProductService.addEvalProduct(evalProduct);
        System.out.println("添加评论成功");
        return "redirect:/productPage/{pid}";

    }

//    @RequestMapping("houtaiPage")
//    public String houtaiPage(){
//        return "htindex";
//    }
//    @RequestMapping("htloginPage")
//    public String htloginPage(){
//        return "htlogin";
//    }



    @RequestMapping("customcenterPage")
    public String customcenterPage(){
        return "customcenter";
    }
    @RequestMapping("payPage")
    public String payPage(){
        return "payindex";
    }
    @RequestMapping("submitsuccessPage")
    public String submitsuccessPage(){
        return "submitsuccess";
    }



    @Autowired
    LCustomInfoService lCustomInfoService;
    @RequestMapping("paysuccessPage")
    public String paysuccessPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
//        int cid = 1;
        int oidstr= 1;
        List<LCustomsOrders> ordersList = ordersService.findAllOrderByCid(cid);
        for (LCustomsOrders order :ordersList){
            if (order.getOid()>oidstr){
                oidstr = order.getOid();
            }
        }
        int oid = oidstr+1;
        int adressid= Integer.parseInt(request.getParameter("adressid"));
        LAdress adress = lCustomInfoService.findeadress(adressid);
        double pprice = Double.parseDouble(request.getParameter("ppriceStr"));
        int pid = Integer.parseInt(request.getParameter("pidStr"));
        int couts = Integer.parseInt(request.getParameter("counts"));
        model.addAttribute("adress",adress);
        model.addAttribute("price",pprice);
        model.addAttribute("oid",oid);
        Date time = new Date();
        ordersService.change(pid,1);
        ordersService.addOrder(oid,cid,adressid,couts,pprice,time);
        String ppriceStr = request.getParameter("ppriceStr");
        infoService.addOrderInfo(oid,pid,couts,pprice);
        return "submitsuccess";
    }


    @RequestMapping("shopcarPage")
    public String shopcarPage(){
        return "shopcar";
    }


//    @RequestMapping("signPage")
//    public String signPage(){
//        return "sign";
//    }

}
