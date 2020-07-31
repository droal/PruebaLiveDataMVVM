package com.example.pruebalivedatamvvm.list;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pruebalivedatamvvm.http.twitchpojos.Game;
import com.example.pruebalivedatamvvm.root.App;
import com.example.pruebalivedatamvvm.root.ApplicationComponent;
import com.example.pruebalivedatamvvm.root.DaggerApplicationComponent;

import java.util.List;

import javax.inject.Inject;

public class GameListViewModel extends ViewModel {

    @Inject
    GameListRepository gameListRepository;

    private MutableLiveData<List<Game>> gameTop20Mutable = null;

    public GameListViewModel() {
        DaggerApplicationComponent.builder().build().inject(this);
    }


    public interface CustomCallback {
        void onSucess(List<Game> topGames);
        void onFailure();
    }

    public LiveData<List<Game>> getObservable(){
        if(gameTop20Mutable == null){
            gameTop20Mutable = new MutableLiveData<>();
        }
        return gameTop20Mutable;
    }

    public void getGamesList(String token){
        gameListRepository.getGamesList(token, new CustomCallback() {
            @Override
            public void onSucess(List<Game> topGames) {
                gameTop20Mutable.setValue(topGames);
            }

            @Override
            public void onFailure() {
                gameTop20Mutable.setValue(null);
            }
        });
    }
}
