package com.journaldev.retrofitintro.eventpojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by aj_wi on 30/05/2017.
 */

public class Group {
    @SerializedName("join_mode")
    @Expose
    private String joinMode;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("group_lon")
    @Expose
    private Double groupLon;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("urlname")
    @Expose
    private String urlname;
    @SerializedName("group_lat")
    @Expose
    private Double groupLat;
    @SerializedName("who")
    @Expose
    private String who;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGroupLon() {
        return groupLon;
    }

    public void setGroupLon(Double groupLon) {
        this.groupLon = groupLon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
