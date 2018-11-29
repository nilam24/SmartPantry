package com.example.src.smartpantry.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Caterer {

    @SerializedName("caterer_firstName")
    @Expose
    private String catererFirstName;
    @SerializedName("caterer_lastName")
    @Expose
    private String catererLastName;
    @SerializedName("caterer_emailId")
    @Expose
    private String catererEmailId;
    @SerializedName("caterer_pass")
    @Expose
    private String catererPass;
    @SerializedName("caterer_contact")
    @Expose
    private String catererContact;
    @SerializedName("caterer_city")
    @Expose
    private String catererCity;
    @SerializedName("caterer_state")
    @Expose
    private String catererState;
    @SerializedName("caterer_country")
    @Expose
    private String catererCountry;

    /**
     * No args constructor for use in serialization
     *
     */
    public Caterer() {
    }

    /**
     *
     * @param catererContact
     * @param catererState
     * @param catererCountry
     * @param catererLastName
     * @param catererEmailId
     * @param catererPass
     * @param catererFirstName
     * @param catererCity
     */
    public Caterer(String catererFirstName, String catererLastName, String catererEmailId, String catererPass, String catererContact, String catererCity, String catererState, String catererCountry) {
        super();
        this.catererFirstName = catererFirstName;
        this.catererLastName = catererLastName;
        this.catererEmailId = catererEmailId;
        this.catererPass = catererPass;
        this.catererContact = catererContact;
        this.catererCity = catererCity;
        this.catererState = catererState;
        this.catererCountry = catererCountry;
    }

    public String getCatererFirstName() {
        return catererFirstName;
    }

    public void setCatererFirstName(String catererFirstName) {
        this.catererFirstName = catererFirstName;
    }

    public String getCatererLastName() {
        return catererLastName;
    }

    public void setCatererLastName(String catererLastName) {
        this.catererLastName = catererLastName;
    }

    public String getCatererEmailId() {
        return catererEmailId;
    }

    public void setCatererEmailId(String catererEmailId) {
        this.catererEmailId = catererEmailId;
    }

    public String getCatererPass() {
        return catererPass;
    }

    public void setCatererPass(String catererPass) {
        this.catererPass = catererPass;
    }

    public String getCatererContact() {
        return catererContact;
    }

    public void setCatererContact(String catererContact) {
        this.catererContact = catererContact;
    }

    public String getCatererCity() {
        return catererCity;
    }

    public void setCatererCity(String catererCity) {
        this.catererCity = catererCity;
    }

    public String getCatererState() {
        return catererState;
    }

    public void setCatererState(String catererState) {
        this.catererState = catererState;
    }

    public String getCatererCountry() {
        return catererCountry;
    }

    public void setCatererCountry(String catererCountry) {
        this.catererCountry = catererCountry;
    }

}