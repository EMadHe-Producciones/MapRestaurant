package com.emadhe.maprestaurant.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.emadhe.maprestaurant.Model.Feature;

@androidx.room.Database(entities = {Feature.class}, version = 1)
@TypeConverters(Converter.class)
public abstract class Database extends RoomDatabase {
    private static Database INSTANCE;
    public abstract RestaurantsDAO restaurantsDAO();

    public static Database getInstance(Context c){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(c.getApplicationContext(), Database.class, "restaurantes")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
