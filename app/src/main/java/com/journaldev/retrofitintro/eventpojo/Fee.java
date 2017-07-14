package com.journaldev.retrofitintro.eventpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aj_wi on 30/05/2017.
 */

public class Fee {
    @SerializedName("amount")
    @Expose
    private Long amount;
    @SerializedName("accepts")
    @Expose
    private String accepts;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("required")
    @Expose
    private String required;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAccepts() {
        return accepts;
    }

    public void setAccepts(String accepts) {
        this.accepts = accepts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }


}
