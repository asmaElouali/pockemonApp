package com.example.pockemonproject.service;


import com.example.pockemonproject.model.GitPockemonResponce;
import com.example.pockemonproject.model.GitPokemon;
import com.example.pockemonproject.model.GitRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitRepoServiceAPI {
    @GET("api/v2/pokemon")
    public Call<GitPockemonResponce> searchPockemons(@Query("page") String query);


    @GET("pokemon/{u}")
    public  Call<List<GitRepo>> pokemonRepositories(@Path("u") String name);

}
