package com.emadhe.maprestaurant.Model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.emadhe.maprestaurant.db.Converter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "features")
public class Feature {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;

    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    private String type;

    @ColumnInfo(name = "relevance")
    @SerializedName("relevance")
    @Expose
    private Double relevance;

    @ColumnInfo(name = "text")
    @SerializedName("text")
    @Expose
    private String text;

    @ColumnInfo(name = "place_name")
    @SerializedName("place_name")
    @Expose
    private String placeName;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "center")
    @SerializedName("center")
    @Expose
    private List<Double> center;


    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setCenter(List<Double> center) {
        this.center = center;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getRelevance() {
        return relevance;
    }

    public String getText() {
        return text;
    }

    public String getPlaceName() {
        return placeName;
    }

    public List<Double> getCenter() {
        return center;
    }
}
