package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.entity.Account;
import com.qssy.exam.webexam.service.AccountService;
import com.qssy.exam.webexam.utils.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zzz
 */
@Controller
@RequestMapping("SystemAccount")
public class SystemAccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("Index")
    public String index(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            List<Account> accounts = accountService.findAllAccount();
            model.addAttribute("accounts", accounts);
            return "account/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "请先登录");
            return "redirect:/Account/SignIn";
        }
    }

    @GetMapping("Create")
    public ModelAndView create() {
        return new ModelAndView("account/create");
    }

    @PostMapping("Create")
    public ModelAndView doCreate(String username, String password) {
        accountService.saveAccount(username,password);
        return new ModelAndView("redirect:/SystemAccount/Index");
    }

    @GetMapping("Edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id,HttpSession session,Model model) {
        Account edit= accountService.findById(id);
        session.setAttribute(ConstantUtil.SESSION_ID, id);
        model.addAttribute("edit",edit);
        return new ModelAndView("account/edit");
    }

    @PostMapping("Edit")
    public ModelAndView doEdit( String username, String password,HttpSession session) {
        int id=(int) session.getAttribute(ConstantUtil.SESSION_ID);
        accountService.EditById(id,username,password);
        return new ModelAndView("redirect:/SystemAccount/Index");
    }

    @GetMapping("Delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        accountService.deleteById(id);
        return new ModelAndView("redirect:/SystemAccount/Index");
    }

}
