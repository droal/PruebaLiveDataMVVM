package com.example.pruebalivedatamvvm.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pruebalivedatamvvm.R;
import com.example.pruebalivedatamvvm.http.twitchpojos.Game;
import com.example.pruebalivedatamvvm.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GamesListActivity extends AppCompatActivity {

    private GameListViewModel gameListViewModel;

    ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);
        listView = findViewById(R.id.lv_games_list);
        ((App) getApplication()).getComponent().inject(this);


        //Obtener el ViewModel
        gameListViewModel = ViewModelProviders.of(this).get(GameListViewModel.class);

        //Inicializar observador
        gameListViewModel.getObservable().observe(this, games ->{
            if (games != null) {
                List<String> gamesArray = new ArrayList<>();

                for (Game game : games) {
                    gamesArray.add(game.getName());

                    ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, gamesArray);
                    listView.setAdapter(adapter);
                }
            } else {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        });
        /*gameListViewModel.getObservable().observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {

                if (games != null) {
                    List<String> gamesArray = new ArrayList<>();

                    for (Game game : games) {
                        gamesArray.add(game.getName());

                        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, gamesArray);
                        listView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                }
            }
        });
*/

        Button btnSearch = findViewById(R.id.btn_games_list_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Actualizar el live data con información actual
                String token = v.getContext().getSharedPreferences("AppPref", Context.MODE_PRIVATE).getString("token", "");
                gameListViewModel.getGamesList(token);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}

