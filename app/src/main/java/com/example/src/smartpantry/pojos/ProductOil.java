package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductOil {

    @SerializedName("product_oil_id")
    @Expose
    private String productOilId;
    @SerializedName("product_oil_img")
    @Expose
    private String productOilImg;
    @SerializedName("product_oil_name")
    @Expose
    private String productOilName;
    @SerializedName("product_oil_quantity")
    @Expose
    private String productOilQuantity;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductOil() {
    }

    /**
     *
     * @param productOilName
     * @param productOilQuantity
     * @param productOilId
     * @param productOilImg
     */
    public ProductOil(String productOilId, String productOilImg, String productOilName, String productOilQuantity) {
        super();
        this.productOilId = productOilId;
        this.productOilImg = productOilImg;
        this.productOilName = productOilName;
        this.productOilQuantity = productOilQuantity;
    }

    public String getProductOilId() {
        return productOilId;
    }

    public void setProductOilId(String productOilId) {
        this.productOilId = productOilId;
    }

    public ProductOil withProductOilId(String productOilId) {
        this.productOilId = productOilId;
        return this;
    }

    public String getProductOilImg() {
        return productOilImg;
    }

    public void setProductOilImg(String productOilImg) {
        this.productOilImg = productOilImg;
    }

    public ProductOil withProductOilImg(String productOilImg) {
        this.productOilImg = productOilImg;
        return this;
    }

    public String getProductOilName() {
        return productOilName;
    }

    public void setProductOilName(String productOilName) {
        this.productOilName = productOilName;
    }

    public ProductOil withProductOilName(String productOilName) {
        this.productOilName = productOilName;
        return this;
    }

    public String getProductOilQuantity() {
        return productOilQuantity;
    }

    public void setProductOilQuantity(String productOilQuantity) {
        this.productOilQuantity = productOilQuantity;
    }

    public ProductOil withProductOilQuantity(String productOilQuantity) {
        this.productOilQuantity = productOilQuantity;
        return this;
    }

}
