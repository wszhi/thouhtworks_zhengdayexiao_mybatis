package com.wsz.controller;
import com.wsz.entity.Cart;
import com.wsz.entity.User;
import com.wsz.service.CartService;
import com.wsz.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Resource(name="userService")
    private UserService userService;
    @Resource(name="cartService")
    private CartService cartService;

    @RequestMapping(value="/index")
    public String getindex(String userid,Model model) {
        if(userid == "" || userid == null){
            model.addAttribute("islogin","login");
        }
        else{
            model.addAttribute("user",userService.getUser(userid));
            model.addAttribute("islogin","welcome!");
        }
        return "home";
    }
    @RequestMapping(value="/login")
    public String searchlogininfo(String name,String psw,Model model){
        User user =userService.selectUser(name,psw);
        if(user !=null){
            model.addAttribute("user",user);
            model.addAttribute("islogin","welcome!");
        }
        else{
            model.addAttribute("islogin","login");
        }
        return "home";

    }
    @RequestMapping(value="/getbookinfo")
    public String getbookinfopage(String bookurl,String userid,Model model){
        model.addAttribute("bookurl",bookurl);
        User user=userService.getUser(userid);
        if(user !=null){
            model.addAttribute("user",user);
            model.addAttribute("islogin","welcome!");
            return "bookinfo";
        }
        else{
            model.addAttribute("islogin","login");
            return "bookinfo";
        }
    }
    @RequestMapping(value="/getcartlist")
    public String getcartlist(String userid,Model model){
        model.addAttribute("user",userService.getUser(userid));
        List<Cart> cartlist=cartService.getCartByUserid(userid);
        model.addAttribute("carts",cartlist);
        double allprice=0.0;
        int allnum=0;
        for(Cart car:cartlist){
            allnum+=car.getNumber();
            allprice+=car.getAllprice();
        }
        model.addAttribute("allprice",allprice);
        model.addAttribute("allnum",allnum);
        return "cartsinfo";

    }

    @RequestMapping(value="/addintocart")
    public String addintocart(String userid,String bookid,String title,String author,String price,String imageurl,Model model){
        if(userid == ""){
            model.addAttribute("islogin","login");
        }
        else{
            String s=price.substring(0,price.length()-1);
            Double prices=Double.parseDouble(s);
            Cart c =cartService.getCartinfo(userid,bookid);
            if(c != null){
                c.setNumber(c.getNumber()+1);
                cartService.updateCart(c);
            }
            else{
                Cart cart =new Cart(userid,bookid,title,author,prices,imageurl,1);
                cartService.insertCart(cart);
            }
            model.addAttribute("user",userService.getUser(userid));
            model.addAttribute("islogin","welcome!");
        }

        return "home";
    }
    @RequestMapping(value="/delfromcart")
    public String delcart(String userid,String cartid,Model model){
        cartService.delCart(cartid);
        model.addAttribute("user",userService.getUser(userid));
        model.addAttribute("carts",cartService.getCartByUserid(userid));
        return "cartsinfo";

    }
    @RequestMapping(value="/updateonecart")
    public String updateonecart(String userid,String bookid,String cartnumber,Model model){
        Cart cart=cartService.getCartinfo(userid,bookid);
        cart.setNumber(Integer.parseInt(cartnumber));
        cartService.updateCart(cart);
        model.addAttribute("user",userService.getUser(userid));
        model.addAttribute("carts",cartService.getCartByUserid(userid));
        return "cartsinfo";

    }
}