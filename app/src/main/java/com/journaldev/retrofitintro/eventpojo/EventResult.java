package com.journaldev.retrofitintro.eventpojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aj_wi on 30/05/2017.
 */

public class EventResult {
    @SerializedName("utc_offset")
    @Expose
    private Long utcOffset;
    @SerializedName("venue")
    @Expose
    private EventVenue venue;
    @SerializedName("rsvp_limit")
    @Expose
    private Long rsvpLimit;
    @SerializedName("headcount")
    @Expose
    private Long headcount;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("waitlist_count")
    @Expose
    private Long waitlistCount;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("maybe_rsvp_count")
    @Expose
    private Long maybeRsvpCount;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("how_to_find_us")
    @Expose
    private String howToFindUs;
    @SerializedName("event_url")
    @Expose
    private String eventUrl;
    @SerializedName("yes_rsvp_count")
    @Expose
    private Long yesRsvpCount;
    @SerializedName("duration")
    @Expose
    private Long duration;
    @SerializedName("announced")
    @Expose
    private Boolean announced;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("eventGroup")
    @Expose
    private EventGroup eventGroup;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("eventFee")
    @Expose
    private EventFee eventFee;

    public Long getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Long utcOffset) {
        this.utcOffset = utcOffset;
    }

    public EventVenue getVenue() {
        return venue;
    }

    public void setVenue(EventVenue venue) {
        this.venue = venue;
    }

    public Long getRsvpLimit() {
        return rsvpLimit;
    }

    public void setRsvpLimit(Long rsvpLimit) {
        this.rsvpLimit = rsvpLimit;
    }

    public Long getHeadcount() {
        return headcount;
    }

    public void setHeadcount(Long headcount) {
        this.headcount = headcount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Long getWaitlistCount() {
        return waitlistCount;
    }

    public void setWaitlistCount(Long waitlistCount) {
        this.waitlistCount = waitlistCount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getMaybeRsvpCount() {
        return maybeRsvpCount;
    }

    public void setMaybeRsvpCount(Long maybeRsvpCount) {
        this.maybeRsvpCount = maybeRsvpCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToFindUs() {
        return howToFindUs;
    }

    public void setHowToFindUs(String howToFindUs) {
        this.howToFindUs = howToFindUs;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public Long getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(Long yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getAnnounced() {
        return announced;
    }

    public void setAnnounced(Boolean announced) {
        this.announced = announced;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public EventGroup getEventGroup() {
        return eventGroup;
    }

    public void setEventGroup(EventGroup eventGroup) {
        this.eventGroup = eventGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EventFee getEventFee() {
        return eventFee;
    }

    public void setEventFee(EventFee eventFee) {
        this.eventFee = eventFee;
    }
}
