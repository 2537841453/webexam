package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.entity.Account;
import com.qssy.exam.webexam.entity.ProductType;
import com.qssy.exam.webexam.service.ProductTypeService;
import com.qssy.exam.webexam.utils.ConstantUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author zzz
 */
@Controller
@RequestMapping("ProductType")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    //productType产品类型列表
    @GetMapping("Index")
    public String index(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            List<ProductType> productTypes = productTypeService.findAllProductType();
            model.addAttribute("productTypes", productTypes);
            return "productType/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "请先登录");
            return "redirect:/Account/SignIn";
        }
    }

    //添加产品类型
    @GetMapping("Create")
    public ModelAndView create(){
        return new ModelAndView("productType/create");
    }
    @PostMapping("Create")
    public ModelAndView doCreate(String productType){
        /**
         * 生成随机UUID作为ID
         */
   /*     String id = UUID.randomUUID().toString();*/
        productTypeService.saveProductType(productType);
        return new ModelAndView("redirect:/ProductType/Index");
    }

    //编辑产品类型
    @GetMapping("Edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id,HttpSession session,Model model){
        ProductType edit= productTypeService.findById(id);
        session.setAttribute(ConstantUtil.SESSION_ID, id);
        model.addAttribute("edit",edit);
        return new ModelAndView("productType/edit");
    }
    @PostMapping("Edit")
    public ModelAndView doEdit(String productType,HttpSession session){
        int id=(int) session.getAttribute(ConstantUtil.SESSION_ID);
        productTypeService.EditById(id,productType);//修改product数据
        return new ModelAndView("redirect:/ProductType/Index");
    }

    //删除
    @GetMapping("Delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id){
        productTypeService.deleteById(id);
        return new ModelAndView("redirect:/ProductType/Index");
    }
}
