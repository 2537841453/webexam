package com.qssy.exam.webexam.dao;

import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.query.ProductQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProduct(Product product);
    List<Product> findAll(ProductQuery productQuery);
    int deleteById(int id);
    int EditById(@Param("id") int id, @Param("productName") String productName,@Param("productType") String productType);
    Product findById(int id);
    int saveProduct( @Param("productName") String productName,@Param("productType") String productType);

}
