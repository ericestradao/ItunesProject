package com.example.user.itunesproject.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesInterfaceApi {

    @GET("search")
    Call<ItunesPojo> getMusic (@Query("term") String term,
                                   @Query("media") String media,
                                   @Query("entity") String entity,
                                   @Query("limit") String limit);


}
