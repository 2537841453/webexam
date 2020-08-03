package com.qssy.exam.webexam.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qssy.exam.webexam.dao.ProductDao;
import com.qssy.exam.webexam.entity.Product;

import com.qssy.exam.webexam.query.ProductQuery;
import com.qssy.exam.webexam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAllProduct(Product product) {
        //分页设置
       /* PageHelper.startPage(product.getPageNum(),product.getPageSize());
        Page<Product> page =(Page<Product>)productDao.findAllProduct(product);
        PageInfo<Product> pageInfo=page.toPageInfo();*/
        return productDao.findAllProduct(product);
    }

    @Override
    public PageInfo<Product> findAll(ProductQuery productQuery) {
        //分页设置
        PageHelper.startPage(1,3);
        Page<Product> page =(Page<Product>)productDao.findAll(productQuery);
        PageInfo<Product> pageInfo=page.toPageInfo();
        return pageInfo;
    }

    @Override
    public int deleteById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public int EditById(int id, String productName, String productType) {
        return productDao.EditById(id,productName,productType);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public int saveProduct(String productName, String productType) {
        return productDao.saveProduct(productName,productType);
    }

}
