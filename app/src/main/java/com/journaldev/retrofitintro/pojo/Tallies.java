package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tallies {

    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("waitlist")
    @Expose
    private Integer waitlist;
    @SerializedName("maybe")
    @Expose
    private Integer maybe;
    @SerializedName("yes")
    @Expose
    private Integer yes;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(Integer waitlist) {
        this.waitlist = waitlist;
    }

    public Integer getMaybe() {
        return maybe;
    }

    public void setMaybe(Integer maybe) {
        this.maybe = maybe;
    }

    public Integer getYes() {
        return yes;
    }

    public void setYes(Integer yes) {
        this.yes = yes;
    }

}