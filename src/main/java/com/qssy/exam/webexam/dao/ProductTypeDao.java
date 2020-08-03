package com.qssy.exam.webexam.dao;

import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.entity.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeDao {
    List<ProductType> findAllProductType();
    int deleteById(int id);
    int saveProductType(@Param("productType") String productType);
    ProductType findById(int id);
    int EditById(@Param("id") int id, @Param("productType") String productType);
    /*int deleteById(int id);
    int EditById(@Param("id") int id, @Param("productName") String productName, @Param("productType") String productType);
    Product findById(int id);
    int saveProduct(@Param("productName") String productName, @Param("productType") String productType);*/
}
