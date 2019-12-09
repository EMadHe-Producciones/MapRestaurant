package com.emadhe.maprestaurant.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {


    @SerializedName("type")
    @Expose
    private String type;


    @SerializedName("query")
    @Expose
    private List<String> query;


    @SerializedName("features")
    @Expose
    public List<Feature> features;

    @SerializedName("attribution")
    @Expose
    private String attribution;


    public String getType() {
        return type;
    }

    public List<String> getQuery() {
        return query;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public String getAttribution() {
        return attribution;
    }
}
