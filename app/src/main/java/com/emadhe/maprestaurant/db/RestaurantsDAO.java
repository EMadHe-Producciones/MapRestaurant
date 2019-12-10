package com.emadhe.maprestaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.emadhe.maprestaurant.Model.Feature;

import java.util.List;

@Dao
public interface RestaurantsDAO {

    @Insert
    void insertRestanurant(Feature feature);

    @Query("SELECT * FROM features")
    List<Feature> seletResponse();
}
