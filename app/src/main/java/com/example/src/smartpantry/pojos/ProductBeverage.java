package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductBeverage {

    @SerializedName("product_beverage_id")
    @Expose
    private String productBeverageId;
    @SerializedName("product_beverage_img")
    @Expose
    private String productBeverageImg;
    @SerializedName("product_beverage_name")
    @Expose
    private String productBeverageName;
    @SerializedName("product_beverage_quantity_in_gm")
    @Expose
    private String productBeverageQuantityInGm;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductBeverage() {
    }

    /**
     *
     * @param productBeverageName
     * @param productBeverageQuantityInGm
     * @param productBeverageId
     * @param productBeverageImg
     */
    public ProductBeverage(String productBeverageId, String productBeverageImg, String productBeverageName, String productBeverageQuantityInGm) {
        super();
        this.productBeverageId = productBeverageId;
        this.productBeverageImg = productBeverageImg;
        this.productBeverageName = productBeverageName;
        this.productBeverageQuantityInGm = productBeverageQuantityInGm;
    }

    public String getProductBeverageId() {
        return productBeverageId;
    }

    public void setProductBeverageId(String productBeverageId) {
        this.productBeverageId = productBeverageId;
    }

    public ProductBeverage withProductBeverageId(String productBeverageId) {
        this.productBeverageId = productBeverageId;
        return this;
    }

    public String getProductBeverageImg() {
        return productBeverageImg;
    }

    public void setProductBeverageImg(String productBeverageImg) {
        this.productBeverageImg = productBeverageImg;
    }

    public ProductBeverage withProductBeverageImg(String productBeverageImg) {
        this.productBeverageImg = productBeverageImg;
        return this;
    }

    public String getProductBeverageName() {
        return productBeverageName;
    }

    public void setProductBeverageName(String productBeverageName) {
        this.productBeverageName = productBeverageName;
    }

    public ProductBeverage withProductBeverageName(String productBeverageName) {
        this.productBeverageName = productBeverageName;
        return this;
    }

    public String getProductBeverageQuantityInGm() {
        return productBeverageQuantityInGm;
    }

    public void setProductBeverageQuantityInGm(String productBeverageQuantityInGm) {
        this.productBeverageQuantityInGm = productBeverageQuantityInGm;
    }

    public ProductBeverage withProductBeverageQuantityInGm(String productBeverageQuantityInGm) {
        this.productBeverageQuantityInGm = productBeverageQuantityInGm;
        return this;
    }

}
