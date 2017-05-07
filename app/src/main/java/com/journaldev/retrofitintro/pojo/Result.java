package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("member_photo")
    @Expose
    private MemberPhoto memberPhoto;
    @SerializedName("tallies")
    @Expose
    private Tallies tallies;
    @SerializedName("guests")
    @Expose
    private Integer guests;
    @SerializedName("member")
    @Expose
    private Member member;
    @SerializedName("rsvp_id")
    @Expose
    private Integer rsvpId;
    @SerializedName("mtime")
    @Expose
    private Long mtime;
    @SerializedName("event")
    @Expose
    private Event event;
    @SerializedName("group")
    @Expose
    private Group group;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public MemberPhoto getMemberPhoto() {
        return memberPhoto;
    }

    public void setMemberPhoto(MemberPhoto memberPhoto) {
        this.memberPhoto = memberPhoto;
    }

    public Tallies getTallies() {
        return tallies;
    }

    public void setTallies(Tallies tallies) {
        this.tallies = tallies;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(Integer rsvpId) {
        this.rsvpId = rsvpId;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}