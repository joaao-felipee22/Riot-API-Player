package com.example.riotapi.model;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIMethod {

    @GET("summoners/by-name/{summonerName}")
    Single<PlayerResponse> getPlayerApi(
            @Path("summonerName") String playerName,
            @Query("api_key")String apiKey
    );
}
