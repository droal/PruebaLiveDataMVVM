package com.example.pruebalivedatamvvm.list;

import android.content.Context;

import com.example.pruebalivedatamvvm.root.ApplicationComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class GameListModule {

    @Provides
    public GameListRepository provideGameListRepository(){
        return new TwitchApiRepository();
    }
}
