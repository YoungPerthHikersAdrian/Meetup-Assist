package com.journaldev.retrofitintro.eventpojo;

/**
 * Created by aj_wi on 29/05/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventExample {

    @SerializedName("results")
    @Expose
    private List<Result> Result = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Result>
    getEventResults() {
        return Result;
    }

    public void setEventResults(List<Result> results) {
        this.Result = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
