package com.example.pockemonproject.model;

import com.google.gson.annotations.SerializedName;

public class GitRepo {
    public int id;
    public String url;
    public String name;
    public int height ;
    @SerializedName("location_area_encounters")
    public String locationCounters;
}
