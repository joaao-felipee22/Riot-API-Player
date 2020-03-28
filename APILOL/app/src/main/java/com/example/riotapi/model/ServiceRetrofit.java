package com.example.riotapi.model;

import com.facebook.stetho.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRetrofit {

    private static final String BASE_URL = "https://br1.api.riotgames.com/lol/summoner/v4/";
    public static final String API_KEY= "RGAPI-41b50665-99ab-44f5-9a0b-f59b34647996";
    public static final String BASE_URL_IMAGE = "https://ddragon.leagueoflegends.com/cdn/10.6.1/img/profileicon/";
    private static retrofit2.Retrofit retrofit;

    private static retrofit2.Retrofit getRetrofit() {

        if (retrofit == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
            }

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    public static APIMethod getApiService() {
        return getRetrofit().create(APIMethod.class);
    }
}
