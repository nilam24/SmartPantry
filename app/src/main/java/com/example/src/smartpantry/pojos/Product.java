package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_img")
    @Expose
    private String productImg;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_quantity")
    @Expose
    private String productQuantity;

    /**
     * No args constructor for use in serialization
     *
     */
    public Product() {
    }

    /**
     *
     * @param productImg
     * @param productQuantity
     * @param productName
     */
    public Product(String productImg, String productName, String productQuantity) {
        super();
        this.productImg = productImg;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

}