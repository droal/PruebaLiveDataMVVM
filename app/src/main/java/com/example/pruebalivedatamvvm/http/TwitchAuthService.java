package com.example.pruebalivedatamvvm.http;

import com.example.pruebalivedatamvvm.http.twitchpojos.TokenResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TwitchAuthService {


    @POST("oauth2/token")
    Call<TokenResponse> authentication(@Query("client_id") String client_id, @Query("client_secret") String client_secret, @Query("grant_type") String grant_type);

}
