package com.journaldev.retrofitintro;

import com.journaldev.retrofitintro.eventpojo.EventExample;
import com.journaldev.retrofitintro.pojo.Event;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.journaldev.retrofitintro.pojo.Example;

/**
 * Created by anupamchugh on 09/01/17.
 */

interface APIInterface {
//partial ULRs
    //https://api.meetup.com/2/events?key=d7559f69581f1c5121f2b28754c2e&group_urlname=ny-tech
    // BASE_URL/API CALL?KEY/API DELIM
    //https://api.meetup.com/2/rsvps?key=d7559f69581f1c5121f2b28754c2e&event_id=238434680&order=name
    //https://api.meetup.com/2/events?key=d7559f69581f1c5121f2b28754c2e&group_urlname=Young-Perth-Hikers
    //TODO look into POST remove RSVP pojo
    @GET("/2/rsvps")
    Call<Example> getRSVP(@Query("key") String apiKey, @Query("event_id") String eventID);
    // Call Class RSVP to store JSON data in pojo serialisation ??

    @GET("/2/events")
    Call<EventExample> getEVENT(@Query("key") String apiKey, @Query("group_urlname") String group_name);
/*
    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}
