package com.qssy.exam.webexam.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qssy.exam.webexam.entity.Account;
import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.entity.ProductType;
import com.qssy.exam.webexam.query.ProductQuery;
import com.qssy.exam.webexam.service.ProductService;
import com.qssy.exam.webexam.service.ProductTypeService;
import com.qssy.exam.webexam.utils.ConstantUtil;
import com.qssy.exam.webexam.utils.JsonModel;
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
@RequestMapping("Product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    //产品列表
    @GetMapping("Index")
    public String index(HttpSession session, RedirectAttributes redirectAttributes, Model model, Product product) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
           List<Product> products=productService.findAllProduct(product);
            model.addAttribute("products", products);
            return "product/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "请先登录");
            return "redirect:/Account/SignIn";
        }
    }

    //添加产品信息
    @GetMapping("Create")
    public ModelAndView create(Model model) {
        List<ProductType> productTypeList=productTypeService.findAllProductType();
        model.addAttribute("productTypeList",productTypeList);
        System.out.println(productTypeList);
        return new ModelAndView("product/create");
    }
    @PostMapping("Create")
    public ModelAndView doCreate(String productName, String productType) {
        productService.saveProduct(productName,productType);
        return new ModelAndView("redirect:/Product/Index");
    }

    //修改产品信息
    @GetMapping("Edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id,HttpSession session,Model model) {
        Product edit= productService.findById(id);
        session.setAttribute(ConstantUtil.SESSION_ID, id);
        model.addAttribute("edit",edit);
        return new ModelAndView("product/edit");
    }
    @PostMapping("Edit")
    public ModelAndView doEdit( String productName, String productType, HttpSession session) {
        int id=(int) session.getAttribute(ConstantUtil.SESSION_ID);
        productService.EditById(id,productName,productType);//修改product数据
        return new ModelAndView("redirect:/Product/Index");
    }
   //删除产品
    @GetMapping("Delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        productService.deleteById(id);
        return new ModelAndView("redirect:/Product/Index");
    }

}
