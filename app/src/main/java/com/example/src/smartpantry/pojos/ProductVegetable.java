package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ProductVegetable {

        @SerializedName("product_vege_id")
        @Expose
        private String productVegeId;
        @SerializedName("product_vege_img")
        @Expose
        private String productVegeImg;
        @SerializedName("product_vege_name")
        @Expose
        private String productVegeName;
        @SerializedName("product_vege_quantity_in_gm")
        @Expose
        private String productVegeQuantityInGm;

        /**
         * No args constructor for use in serialization
         *
         */
        public ProductVegetable() {
        }

        /**
         *
         * @param productVegeId
         * @param productVegeQuantityInGm
         * @param productVegeName
         * @param productVegeImg
         */
        public ProductVegetable(String productVegeId, String productVegeImg, String productVegeName, String productVegeQuantityInGm) {
            super();
            this.productVegeId = productVegeId;
            this.productVegeImg = productVegeImg;
            this.productVegeName = productVegeName;
            this.productVegeQuantityInGm = productVegeQuantityInGm;
        }

        public String getProductVegeId() {
            return productVegeId;
        }

        public void setProductVegeId(String productVegeId) {
            this.productVegeId = productVegeId;
        }

        public String getProductVegeImg() {
            return productVegeImg;
        }

        public void setProductVegeImg(String productVegeImg) {
            this.productVegeImg = productVegeImg;
        }

        public String getProductVegeName() {
            return productVegeName;
        }

        public void setProductVegeName(String productVegeName) {
            this.productVegeName = productVegeName;
        }

        public String getProductVegeQuantityInGm() {
            return productVegeQuantityInGm;
        }

        public void setProductVegeQuantityInGm(String productVegeQuantityInGm) {
            this.productVegeQuantityInGm = productVegeQuantityInGm;
        }

    }


