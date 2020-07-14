package com.zking.controller;

import com.zking.dao.UserDao;
import com.zking.entity.UserEntity;
import com.zking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/12.
 */

@Controller
@RequestMapping("/front/*")
public class IndexController {

    @Autowired
    private UserDao userDao ;
   
    private User user=new User();
    private UserEntity userEntity=new UserEntity();
    

    //index页面
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    
    //登录页面
    @RequestMapping("/login")
    public String login() {
        String str="";
        String username=user.getUsername();
        if(username!=null) {
        str="index";
        }else {
            str="login";
        }
        return str;
    }
    

    //注册方法
    @RequestMapping("/addregister")
    public String register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)){
            //UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userDao.save(userEntity);
            return "index";
        }else {
            return "register";
        }
    }
    
    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request,HttpSession session) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        userEntity=userDao.findByUsernameAndPassword(username, password);
        String str="";
       if(userEntity!=null) {
            session.setAttribute("userLogin", userEntity);
            str="index";
        }else {
            str="login";
        }
        return str;
    }

}
