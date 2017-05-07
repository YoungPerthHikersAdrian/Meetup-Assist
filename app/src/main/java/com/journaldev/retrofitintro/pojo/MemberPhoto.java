package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberPhoto {

    @SerializedName("highres_link")
    @Expose
    private String highresLink;
    @SerializedName("photo_id")
    @Expose
    private Integer photoId;
    @SerializedName("base_url")
    @Expose
    private String baseUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo_link")
    @Expose
    private String photoLink;
    @SerializedName("thumb_link")
    @Expose
    private String thumbLink;

    public String getHighresLink() {
        return highresLink;
    }

    public void setHighresLink(String highresLink) {
        this.highresLink = highresLink;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getThumbLink() {
        return thumbLink;
    }

    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }

}