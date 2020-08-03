package com.qssy.exam.webexam.service;

import com.github.pagehelper.PageInfo;
import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.query.ProductQuery;

import java.util.List;

public interface ProductService {
    /*PageInfo<Product> findAllProduct(Product product);*/
    List<Product> findAllProduct(Product product);
    PageInfo<Product> findAll(ProductQuery productQuery);
    int deleteById(int id);
    int EditById(int id, String productName, String productType);
    Product findById(int id);
    int saveProduct(String productName,String productType);
}
