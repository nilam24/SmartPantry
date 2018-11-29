package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductNon {

    @SerializedName("product_non_veg_id")
    @Expose
    private String productNonVegId;
    @SerializedName("product_non_veg_img")
    @Expose
    private String productNonVegImg;
    @SerializedName("product_non_veg_name")
    @Expose
    private String productNonVegName;
    @SerializedName("product_non_veg_quantity")
    @Expose
    private String productNonVegQuantity;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductNon() {
    }

    /**
     *
     * @param productNonVegImg
     * @param productNonVegId
     * @param productNonVegQuantity
     * @param productNonVegName
     */
    public ProductNon(String productNonVegId, String productNonVegImg, String productNonVegName, String productNonVegQuantity) {
        super();
        this.productNonVegId = productNonVegId;
        this.productNonVegImg = productNonVegImg;
        this.productNonVegName = productNonVegName;
        this.productNonVegQuantity = productNonVegQuantity;
    }

    public String getProductNonVegId() {
        return productNonVegId;
    }

    public void setProductNonVegId(String productNonVegId) {
        this.productNonVegId = productNonVegId;
    }

    public ProductNon withProductNonVegId(String productNonVegId) {
        this.productNonVegId = productNonVegId;
        return this;
    }

    public String getProductNonVegImg() {
        return productNonVegImg;
    }

    public void setProductNonVegImg(String productNonVegImg) {
        this.productNonVegImg = productNonVegImg;
    }

    public ProductNon withProductNonVegImg(String productNonVegImg) {
        this.productNonVegImg = productNonVegImg;
        return this;
    }

    public String getProductNonVegName() {
        return productNonVegName;
    }

    public void setProductNonVegName(String productNonVegName) {
        this.productNonVegName = productNonVegName;
    }

    public ProductNon withProductNonVegName(String productNonVegName) {
        this.productNonVegName = productNonVegName;
        return this;
    }

    public String getProductNonVegQuantity() {
        return productNonVegQuantity;
    }

    public void setProductNonVegQuantity(String productNonVegQuantity) {
        this.productNonVegQuantity = productNonVegQuantity;
    }

    public ProductNon withProductNonVegQuantity(String productNonVegQuantity) {
        this.productNonVegQuantity = productNonVegQuantity;
        return this;
    }

}
