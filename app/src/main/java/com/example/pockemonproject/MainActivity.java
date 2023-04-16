package com.example.pockemonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import retrofit2.Call;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pockemonproject.model.GitPockemonResponce;
import com.example.pockemonproject.model.GitPokemon;
import com.example.pockemonproject.model.GitRepo;
import com.example.pockemonproject.model.PockemonListViewModel;
import com.example.pockemonproject.service.GitRepoServiceAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<GitRepo> data = new ArrayList<>();
    public static final String POKEMON_PARAM = "pokemon.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy =new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        final EditText editTextQuery = findViewById(R.id.editTextQuery);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        ListView listViewPockemons = findViewById(R.id.listViewUsers);
        //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        PockemonListViewModel listViewModel=new PockemonListViewModel(this,R.layout.pockemons_list_view_layout,data);
        listViewPockemons.setAdapter(listViewModel);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        buttonSearch.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                String query = editTextQuery.getText().toString();
                                                Log.i("", query);
                                                final GitRepoServiceAPI gitRepoServiceAPI = retrofit.create(GitRepoServiceAPI.class);
                                                Call<GitPockemonResponce> callGitPockemon = gitRepoServiceAPI.searchPockemons(query);
                                                callGitPockemon.enqueue(new Callback<GitPockemonResponce>() {
                                                    @Override
                                                    public void onResponse(Call<GitPockemonResponce> call, Response<GitPockemonResponce> response) {
                                                        Log.i("info", call.request().url().toString());
                                                        if (!response.isSuccessful()) {
                                                            Log.i("info", String.valueOf(response.code()));
                                                            return;
                                                        }
                                                        GitPockemonResponce gitPockemonResponce = response.body();
                                                        data.clear();
                                                        for (GitRepo pokemon : gitPockemonResponce.Pokemons) {
                                                            data.add(pokemon);
                                                        }
                                                        listViewModel.notifyDataSetChanged();
                                                        //arrayAdapter.notifyDataSetChanged();
                                                    }

                                                    @Override
                                                    public void onFailure(Call<GitPockemonResponce> call, Throwable t) {
                                                        Log.e("error", "Error");
                                                    }
                                                });
                                            }
                                        });


                listViewPockemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String name=data.get(i).name;
                        Log.i("info", name);
                        Intent intent = new Intent(getApplicationContext(),RepositoryActivity.class);
                        intent.putExtra(POKEMON_PARAM,name);
                        startActivity(intent);
                    }
                });

            }
        }

