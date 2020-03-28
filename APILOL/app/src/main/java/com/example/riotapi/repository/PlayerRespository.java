package com.example.riotapi.repository;

import com.example.riotapi.model.PlayerResponse;

import io.reactivex.Single;

import static com.example.riotapi.model.ServiceRetrofit.getApiService;

public class PlayerRespository {

    public Single<PlayerResponse> playerResponseSingle(String playerName, String apikey){
        return getApiService().getPlayerApi(playerName, apikey);
    }
}
