package com.qssy.exam.webexam.service;

import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.entity.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAllProductType();
    int deleteById(int id);
    int saveProductType(@Param("productType") String productType);
    ProductType findById(int id);
    int EditById(int id,  String productType);
}
