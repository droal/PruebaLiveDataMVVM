package com.example.pruebalivedatamvvm.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pruebalivedatamvvm.http.twitchpojos.Game;
import com.example.pruebalivedatamvvm.http.twitchpojos.Twitch;

import java.util.List;

import io.reactivex.Observable;

public interface GameListRepository {

    void getGamesList(String token, GameListViewModel.CustomCallback callback);
}
