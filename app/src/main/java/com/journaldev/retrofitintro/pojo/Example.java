package com.journaldev.retrofitintro.pojo;

/**
 * Created by Ajess on 1/04/2017.
 */



        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
        import com.journaldev.retrofitintro.pojo.Member;

public class Example {

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("meta")
    @Expose
    private Meta meta;



    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Meta getEventMeta() {
        return meta;
    }

    public void setEventMeta(Meta meta) {
        this.meta = meta;
    }

}