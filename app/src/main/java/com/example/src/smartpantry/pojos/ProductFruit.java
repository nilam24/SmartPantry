package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ProductFruit {

        @SerializedName("product_fruit_id")
        @Expose
        private String productFruitId;
        @SerializedName("product_fruit_img")
        @Expose
        private String productFruitImg;
        @SerializedName("product_fruit_name")
        @Expose
        private String productFruitName;
        @SerializedName("product_fruit_quantity_in_gm")
        @Expose
        private String productFruitQuantityInGm;

        /**
         * No args constructor for use in serialization
         *
         */
        public ProductFruit() {
        }

        /**
         *
         * @param productFruitId
         * @param productFruitImg
         * @param productFruitName
         * @param productFruitQuantityInGm
         */
        public ProductFruit(String productFruitId, String productFruitImg, String productFruitName, String productFruitQuantityInGm) {
            super();
            this.productFruitId = productFruitId;
            this.productFruitImg = productFruitImg;
            this.productFruitName = productFruitName;
            this.productFruitQuantityInGm = productFruitQuantityInGm;
        }

        public String getProductFruitId() {
            return productFruitId;
        }

        public void setProductFruitId(String productFruitId) {
            this.productFruitId = productFruitId;
        }

        public String getProductFruitImg() {
            return productFruitImg;
        }

        public void setProductFruitImg(String productFruitImg) {
            this.productFruitImg = productFruitImg;
        }

        public String getProductFruitName() {
            return productFruitName;
        }

        public void setProductFruitName(String productFruitName) {
            this.productFruitName = productFruitName;
        }

        public String getProductFruitQuantityInGm() {
            return productFruitQuantityInGm;
        }

        public void setProductFruitQuantityInGm(String productFruitQuantityInGm) {
            this.productFruitQuantityInGm = productFruitQuantityInGm;
        }

    }

