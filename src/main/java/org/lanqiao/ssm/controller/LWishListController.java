package org.lanqiao.ssm.controller;

import org.lanqiao.ssm.pojo.LWishList;
import org.lanqiao.ssm.service.LWishListSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LWishListController {
    @Autowired
    LWishListSercice lWishListSercice;
    @RequestMapping("showWishList")
    public String wishlistPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        List<LWishList>  wishList= lWishListSercice.findALLwishListByCid(cid);
        model.addAttribute("wishList",wishList);
        return "wishlist";
    }
    @DeleteMapping("deltWishpro/{pid}")
    public String deleteWishProcuct(@PathVariable int pid,HttpServletRequest request){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        lWishListSercice.removeProdct(pid,cid);
        return "redirect:/showWishList";
    }

    @GetMapping("jiaruWishList/{pid}")
    public String AddWishListByCid(@PathVariable int pid,HttpServletRequest request){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        lWishListSercice.addWishList(cid,pid);
        return "redirect:/productPage/"+pid;
    }

    @DeleteMapping("deltWishproPage/{pid}")
    public String deleteWishPr(@PathVariable int pid,HttpServletRequest request){
        HttpSession session = request.getSession();
        String cidStr = session.getAttribute("Cid").toString();
        int cid = Integer.parseInt(cidStr);
        lWishListSercice.removeProdct(pid,cid);
        return "redirect:/productPage/"+pid;
    }
}
