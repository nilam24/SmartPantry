package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductMilk {

    @SerializedName("product_milk_id")
    @Expose
    private String productMilkId;
    @SerializedName("product_milk_img")
    @Expose
    private String productMilkImg;
    @SerializedName("product_milk_name")
    @Expose
    private String productMilkName;
    @SerializedName("product_milk_quantity")
    @Expose
    private String productMilkQuantity;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductMilk() {
    }

    /**
     *
     * @param productMilkName
     * @param productMilkQuantity
     * @param productMilkImg
     * @param productMilkId
     */
    public ProductMilk(String productMilkId, String productMilkImg, String productMilkName, String productMilkQuantity) {
        super();
        this.productMilkId = productMilkId;
        this.productMilkImg = productMilkImg;
        this.productMilkName = productMilkName;
        this.productMilkQuantity = productMilkQuantity;
    }

    public String getProductMilkId() {
        return productMilkId;
    }

    public void setProductMilkId(String productMilkId) {
        this.productMilkId = productMilkId;
    }

    public ProductMilk withProductMilkId(String productMilkId) {
        this.productMilkId = productMilkId;
        return this;
    }

    public String getProductMilkImg() {
        return productMilkImg;
    }

    public void setProductMilkImg(String productMilkImg) {
        this.productMilkImg = productMilkImg;
    }

    public ProductMilk withProductMilkImg(String productMilkImg) {
        this.productMilkImg = productMilkImg;
        return this;
    }

    public String getProductMilkName() {
        return productMilkName;
    }

    public void setProductMilkName(String productMilkName) {
        this.productMilkName = productMilkName;
    }

    public ProductMilk withProductMilkName(String productMilkName) {
        this.productMilkName = productMilkName;
        return this;
    }

    public String getProductMilkQuantity() {
        return productMilkQuantity;
    }

    public void setProductMilkQuantity(String productMilkQuantity) {
        this.productMilkQuantity = productMilkQuantity;
    }

    public ProductMilk withProductMilkQuantity(String productMilkQuantity) {
        this.productMilkQuantity = productMilkQuantity;
        return this;
    }

}
