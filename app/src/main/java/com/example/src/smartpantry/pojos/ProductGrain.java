package com.example.src.smartpantry.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductGrain {
    @SerializedName("product_grain_id")
    @Expose
    private String productGrainId;
    @SerializedName("product_grain_img")
    @Expose
    private String productGrainImg;
    @SerializedName("product_grain_name")
    @Expose
    private String productGrainName;
    @SerializedName("product_grain_quantity_in_gm")
    @Expose
    private String productGrainQuantityInGm;

    /**
     * No args constructor for use in serialization
     */
    public ProductGrain() {
    }

    /**
     * @param productGrainImg
     * @param productGrainName
     * @param productGrainId
     * @param productGrainQuantityInGm
     */
    public ProductGrain(String productGrainId, String productGrainImg, String productGrainName, String productGrainQuantityInGm) {
        super();
        this.productGrainId = productGrainId;
        this.productGrainImg = productGrainImg;
        this.productGrainName = productGrainName;
        this.productGrainQuantityInGm = productGrainQuantityInGm;
    }

    public String getProductGrainId() {
        return productGrainId;
    }

    public void setProductGrainId(String productGrainId) {
        this.productGrainId = productGrainId;
    }

    public ProductGrain withProductGrainId(String productGrainId) {
        this.productGrainId = productGrainId;
        return this;
    }

    public String getProductGrainImg() {
        return productGrainImg;
    }

    public void setProductGrainImg(String productGrainImg) {
        this.productGrainImg = productGrainImg;
    }

    public ProductGrain withProductGrainImg(String productGrainImg) {
        this.productGrainImg = productGrainImg;
        return this;
    }

    public String getProductGrainName() {
        return productGrainName;
    }

    public void setProductGrainName(String productGrainName) {
        this.productGrainName = productGrainName;
    }

    public ProductGrain withProductGrainName(String productGrainName) {
        this.productGrainName = productGrainName;
        return this;
    }

    public String getProductGrainQuantityInGm() {
        return productGrainQuantityInGm;
    }

    public void setProductGrainQuantityInGm(String productGrainQuantityInGm) {
        this.productGrainQuantityInGm = productGrainQuantityInGm;
    }

    public ProductGrain withProductGrainQuantityInGm(String productGrainQuantityInGm) {
        this.productGrainQuantityInGm = productGrainQuantityInGm;
        return this;
    }

}

