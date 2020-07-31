package com.example.pruebalivedatamvvm.list;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pruebalivedatamvvm.http.TwitchAPIService;
import com.example.pruebalivedatamvvm.http.twitchpojos.Game;
import com.example.pruebalivedatamvvm.http.twitchpojos.Twitch;
import com.example.pruebalivedatamvvm.root.App;
import com.example.pruebalivedatamvvm.root.ApplicationComponent;
import com.example.pruebalivedatamvvm.root.DaggerApplicationComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwitchApiRepository extends App implements GameListRepository {

    @Inject
    TwitchAPIService twitchAPIService;

    public TwitchApiRepository() {
        DaggerApplicationComponent.builder().build().inject(this);
    }

    @Override
    public void getGamesList(String token, GameListViewModel.CustomCallback callback) {

        twitchAPIService.getTopGames("Bearer "+token, "tuev4s9hwme3ddcgvogj1psrk0h3qp").enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                if(response.isSuccessful()){
                    callback.onSucess(response.body().getGame());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

}
