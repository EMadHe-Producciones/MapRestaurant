package com.emadhe.maprestaurant.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.emadhe.maprestaurant.Model.Feature;

@Dao
public interface RestaurantsDAO {

    @Insert
    void insertRestanurant(Feature feature);

    @Query("SELECT * FROM features")
    Feature seletResponse();
}
