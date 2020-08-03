package com.qssy.exam.webexam.entity;

public class ProductType {

    private Integer id;
    private String productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                '}';
    }
}
