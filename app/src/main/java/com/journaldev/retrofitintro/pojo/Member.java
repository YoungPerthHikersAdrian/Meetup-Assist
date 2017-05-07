package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("member_id")
    @Expose
    private Integer memberId;
    @SerializedName("name")
    @Expose
    private String name;

    public Member(Integer memberId, String name ){
        this.memberId = memberId;
        this.name = name;


    }




    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}