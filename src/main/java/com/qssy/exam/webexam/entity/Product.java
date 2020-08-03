package com.qssy.exam.webexam.entity;

import com.qssy.exam.webexam.query.BaseQuery;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String productName;
    private String productType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}
