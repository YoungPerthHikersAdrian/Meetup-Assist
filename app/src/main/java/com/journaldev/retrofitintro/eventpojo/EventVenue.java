package com.journaldev.retrofitintro.eventpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aj_wi on 30/05/2017.
 */

public class EventVenue {
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("localized_country_name")
    @Expose
    private String localizedCountryName;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address_1")
    @Expose
    private String address1;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lon")
    @Expose
    private Long lon;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("lat")
    @Expose
    private Long lat;
    @SerializedName("repinned")
    @Expose
    private Boolean repinned;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalizedCountryName() {
        return localizedCountryName;
    }

    public void setLocalizedCountryName(String localizedCountryName) {
        this.localizedCountryName = localizedCountryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Boolean getRepinned() {
        return repinned;
    }

    public void setRepinned(Boolean repinned) {
        this.repinned = repinned;
    }
}
