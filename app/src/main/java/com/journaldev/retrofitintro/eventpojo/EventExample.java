package com.journaldev.retrofitintro.eventpojo;

/**
 * Created by aj_wi on 29/05/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventExample {

    @SerializedName("eventResults")
    @Expose
    private List<EventResult> Results = null;
    @SerializedName("meta")
    @Expose
    private EventMeta meta;

    public List<EventResult>
    getEventResults() {
        return Results;
    }

    public void setEventResults(List<EventResult> eventResults) {
        this.Results = eventResults;
    }

    public EventMeta getMeta() {
        return meta;
    }

    public void setMeta(EventMeta meta) {
        this.meta = meta;
    }
}
