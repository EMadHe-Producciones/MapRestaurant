package com.emadhe.maprestaurant.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.emadhe.maprestaurant.Model.Feature;

@Database(entities = {Feature.class}, version = 1)

public abstract class database extends RoomDatabase {
    private static database INSTANCE;
    public abstract RestaurantsDAO restaurantsDAO();

    public static database getInstance(Context c){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(c.getApplicationContext(), database.class, "restaurantes")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
