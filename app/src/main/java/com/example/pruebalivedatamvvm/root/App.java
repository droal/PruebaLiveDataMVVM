package com.example.pruebalivedatamvvm.root;


/**Logica de la clase Apliccation*/

import android.app.Application;

import com.example.pruebalivedatamvvm.http.TwitchModule;
import com.example.pruebalivedatamvvm.list.GameListModule;
import com.example.pruebalivedatamvvm.login.LoginModule;

/**Acá se declaran los modulos que requiere la aplicación*/
public class   App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .twitchModule(new TwitchModule())
                .gameListModule(new GameListModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
