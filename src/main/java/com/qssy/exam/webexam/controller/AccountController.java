package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.entity.Account;
import com.qssy.exam.webexam.result.Result;
import com.qssy.exam.webexam.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author zzz
 */
@Controller
/*@RequestMapping("api/Account")*/
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String singIn() {
        return "account/signIn";
    }

    //登录
    @PostMapping("SignIn")
    public String doSignIn(String username, String password, Model model, HttpSession session) {
        Account account = accountService.findAccountByUsername(username);
        String s;
        if (username.equals("")) {
            model.addAttribute("msg", "请输入账号");
            s="account/signIn";
        } else if (password.equals("")) {
            model.addAttribute("msg", "请输入密码");
            model.addAttribute("username", username);
            s="account/signIn";
        } else if (account != null && account.getPassword().contentEquals(password)) {
            session.setAttribute("account",account);
//            System.out.println(username+"登录成功");
            s="redirect:/Product/Index";
        } else {
            model.addAttribute("msg", "登录错误");
            model.addAttribute("username", username);
//            System.out.println(username+"登录失败"+" 密码"+password);
            s="account/signIn";
        }
        return s;
    }
    //退出登录
    @GetMapping("SignOut")
    public String signOut(HttpServletRequest request) {
       /* request.getSession().removeAttribute("account");*/
        return "redirect:SignIn";
    }
/*    @GetMapping("Text")
    public String text() {
        return "product/text";
    }

    @GetMapping("fenye")
    public String fenye() {
        return "product/fenye";
    }*/
}
