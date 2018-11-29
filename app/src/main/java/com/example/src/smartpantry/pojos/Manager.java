package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Manager {

    @SerializedName("manager_firstName")
    @Expose
    private String managerFirstName;
    @SerializedName("manager_lastName")
    @Expose
    private String managerLastName;
    @SerializedName("manager_emailId")
    @Expose
    private String managerEmailId;
    @SerializedName("manager_pass")
    @Expose
    private String managerPass;
    @SerializedName("manager_contact")
    @Expose
    private String managerContact;
    @SerializedName("manager_city")
    @Expose
    private String managerCity;
    @SerializedName("manager_state")
    @Expose
    private String managerState;
    @SerializedName("manager_country")
    @Expose
    private String managerCountry;

    /**
     * No args constructor for use in serialization
     *
     */
    public Manager() {
    }

    /**
     *
     * @param managerFirstName
     * @param managerContact
     * @param managerPass
     * @param managerCountry
     * @param managerEmailId
     * @param managerCity
     * @param managerLastName
     * @param managerState
     */
    public Manager(String managerFirstName, String managerLastName, String managerEmailId, String managerPass, String managerContact, String managerCity, String managerState, String managerCountry) {
        super();
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.managerEmailId = managerEmailId;
        this.managerPass = managerPass;
        this.managerContact = managerContact;
        this.managerCity = managerCity;
        this.managerState = managerState;
        this.managerCountry = managerCountry;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getManagerEmailId() {
        return managerEmailId;
    }

    public void setManagerEmailId(String managerEmailId) {
        this.managerEmailId = managerEmailId;
    }

    public String getManagerPass() {
        return managerPass;
    }

    public void setManagerPass(String managerPass) {
        this.managerPass = managerPass;
    }

    public String getManagerContact() {
        return managerContact;
    }

    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact;
    }

    public String getManagerCity() {
        return managerCity;
    }

    public void setManagerCity(String managerCity) {
        this.managerCity = managerCity;
    }

    public String getManagerState() {
        return managerState;
    }

    public void setManagerState(String managerState) {
        this.managerState = managerState;
    }

    public String getManagerCountry() {
        return managerCountry;
    }

    public void setManagerCountry(String managerCountry) {
        this.managerCountry = managerCountry;
    }

}