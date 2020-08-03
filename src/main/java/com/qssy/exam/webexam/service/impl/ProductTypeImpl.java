package com.qssy.exam.webexam.service.impl;
import com.qssy.exam.webexam.dao.ProductTypeDao;
import com.qssy.exam.webexam.entity.Product;
import com.qssy.exam.webexam.entity.ProductType;
import com.qssy.exam.webexam.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeImpl implements ProductTypeService {
    @Autowired
    private ProductTypeDao productTypeDao;


    @Override
    public List<ProductType> findAllProductType() {
        return productTypeDao.findAllProductType();
    }

    @Override
    public int deleteById(int id) {
        return productTypeDao.deleteById(id);
    }

    @Override
    public int saveProductType(String productType) {
        return productTypeDao.saveProductType(productType);
    }

    @Override
    public ProductType findById(int id) {
        return productTypeDao.findById(id);
    }

    @Override
    public int EditById(int id, String productType) {
        return productTypeDao.EditById(id,productType);
    }

}
