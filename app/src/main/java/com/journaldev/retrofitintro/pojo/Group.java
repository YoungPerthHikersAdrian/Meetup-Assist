package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("join_mode")
    @Expose
    private String joinMode;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("group_lon")
    @Expose
    private Double groupLon;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("urlname")
    @Expose
    private String urlname;
    @SerializedName("group_lat")
    @Expose
    private Double groupLat;

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(String joinMode) {
        this.joinMode = joinMode;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Double getGroupLon() {
        return groupLon;
    }

    public void setGroupLon(Double groupLon) {
        this.groupLon = groupLon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public Double getGroupLat() {
        return groupLat;
    }

    public void setGroupLat(Double groupLat) {
        this.groupLat = groupLat;
    }

}