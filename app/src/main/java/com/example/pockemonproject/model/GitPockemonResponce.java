package com.example.pockemonproject.model;

import com.google.gson.annotations.SerializedName;
 import java.util.List;
import java.util.ArrayList;

public class GitPockemonResponce {
    public int count;
    @SerializedName("results")
    public List<GitRepo> Pokemons=new ArrayList<>();
}
