package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllocationPojo {

    @SerializedName("distributor_emailId")
    @Expose
    private String distributorEmailId;
    @SerializedName("distributor_firstName")
    @Expose
    private String distributorFirstName;
    @SerializedName("distributor_contact")
    @Expose
    private String distributorContact;
    @SerializedName("food_category")
    @Expose
    private String foodCategory;

    /**
     * No args constructor for use in serialization
     *
     */
    public AllocationPojo() {
    }

    /**
     *
     * @param foodCategory
     * @param distributorContact
     * @param distributorEmailId
     * @param distributorFirstName
     */
    public AllocationPojo(String distributorEmailId, String distributorFirstName, String distributorContact, String foodCategory) {
        super();
        this.distributorEmailId = distributorEmailId;
        this.distributorFirstName = distributorFirstName;
        this.distributorContact = distributorContact;
        this.foodCategory = foodCategory;
    }

    public AllocationPojo(String distributorEmailId,String foodCategory){
        super();
        this.distributorEmailId=distributorEmailId;
        this.foodCategory=foodCategory;

    }

    public String getDistributorEmailId() {
        return distributorEmailId;
    }

    public void setDistributorEmailId(String distributorEmailId) {
        this.distributorEmailId = distributorEmailId;
    }

    public AllocationPojo withDistributorEmailId(String distributorEmailId) {
        this.distributorEmailId = distributorEmailId;
        return this;
    }

    public String getDistributorFirstName() {
        return distributorFirstName;
    }

    public void setDistributorFirstName(String distributorFirstName) {
        this.distributorFirstName = distributorFirstName;
    }

    public AllocationPojo withDistributorFirstName(String distributorFirstName) {
        this.distributorFirstName = distributorFirstName;
        return this;
    }

    public String getDistributorContact() {
        return distributorContact;
    }

    public void setDistributorContact(String distributorContact) {
        this.distributorContact = distributorContact;
    }

    public AllocationPojo withDistributorContact(String distributorContact) {
        this.distributorContact = distributorContact;
        return this;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public AllocationPojo withFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
        return this;
    }

    @Override
    public String toString() {
        return "AllocationPojo{" +
                "distributorEmailId='" + distributorEmailId + '\'' +
                ", distributorFirstName='" + distributorFirstName + '\'' +
                ", distributorContact='" + distributorContact + '\'' +
                ", foodCategory='" + foodCategory + '\'' +
                '}';
    }
}
