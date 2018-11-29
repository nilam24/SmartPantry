package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Distributor {

    @SerializedName("distributor_firstName")
    @Expose
    private String distributorFirstName;
    @SerializedName("distributor_lastName")
    @Expose
    private String distributorLastName;
    @SerializedName("distributor_emailId")
    @Expose
    private String distributorEmailId;
    @SerializedName("distributor_pass")
    @Expose
    private String distributorPass;
    @SerializedName("distributor_contact")
    @Expose
    private String distributorContact;
    @SerializedName("distributor_city")
    @Expose
    private String distributorCity;
    @SerializedName("distributor_state")
    @Expose
    private String distributorState;
    @SerializedName("distributor_country")
    @Expose
    private String distributorCountry;

    /**
     * No args constructor for use in serialization
     *
     */
    public Distributor() {
    }

    /**
     *
     * @param distributorCountry
     * @param distributorContact
     * @param distributorState
     * @param distributorEmailId
     * @param distributorFirstName
     * @param distributorCity
     * @param distributorLastName
     * @param distributorPass
     */
    public Distributor(String distributorFirstName, String distributorLastName, String distributorEmailId, String distributorPass, String distributorContact, String distributorCity, String distributorState, String distributorCountry) {
        super();
        this.distributorFirstName = distributorFirstName;
        this.distributorLastName = distributorLastName;
        this.distributorEmailId = distributorEmailId;
        this.distributorPass = distributorPass;
        this.distributorContact = distributorContact;
        this.distributorCity = distributorCity;
        this.distributorState = distributorState;
        this.distributorCountry = distributorCountry;
    }

    public String getDistributorFirstName() {
        return distributorFirstName;
    }

    public void setDistributorFirstName(String distributorFirstName) {
        this.distributorFirstName = distributorFirstName;
    }

    public String getDistributorLastName() {
        return distributorLastName;
    }

    public void setDistributorLastName(String distributorLastName) {
        this.distributorLastName = distributorLastName;
    }

    public String getDistributorEmailId() {
        return distributorEmailId;
    }

    public void setDistributorEmailId(String distributorEmailId) {
        this.distributorEmailId = distributorEmailId;
    }

    public String getDistributorPass() {
        return distributorPass;
    }

    public void setDistributorPass(String distributorPass) {
        this.distributorPass = distributorPass;
    }

    public String getDistributorContact() {
        return distributorContact;
    }

    public void setDistributorContact(String distributorContact) {
        this.distributorContact = distributorContact;
    }

    public String getDistributorCity() {
        return distributorCity;
    }

    public void setDistributorCity(String distributorCity) {
        this.distributorCity = distributorCity;
    }

    public String getDistributorState() {
        return distributorState;
    }

    public void setDistributorState(String distributorState) {
        this.distributorState = distributorState;
    }

    public String getDistributorCountry() {
        return distributorCountry;
    }

    public void setDistributorCountry(String distributorCountry) {
        this.distributorCountry = distributorCountry;
    }

}