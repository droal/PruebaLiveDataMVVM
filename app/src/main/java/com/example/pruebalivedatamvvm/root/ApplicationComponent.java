package com.example.pruebalivedatamvvm.root;


import com.example.pruebalivedatamvvm.http.TwitchModule;
import com.example.pruebalivedatamvvm.list.GameListModule;
import com.example.pruebalivedatamvvm.list.GameListViewModel;
import com.example.pruebalivedatamvvm.list.GamesListActivity;
import com.example.pruebalivedatamvvm.list.TwitchApiRepository;
import com.example.pruebalivedatamvvm.login.LoginActivity;
import com.example.pruebalivedatamvvm.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**Determina las dependencias que se van a injectar (Actividades, servicios, fragmentos..)*/
/**Se utiliza para asignar referencias a Actividades, servicios, fragmentos..*/

/**Se indica el modulo del cual depende el componente*/
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, TwitchModule.class, GameListModule.class})
public interface ApplicationComponent {

    //Método de inyección
    void inject(LoginActivity target);
    void inject(TwitchApiRepository twitchApiRepository);
    void inject(GameListViewModel viewModel);
    void inject(GamesListActivity target);
}
