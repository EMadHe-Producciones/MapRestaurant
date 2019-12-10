package com.emadhe.maprestaurant.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converter {
    @TypeConverter
    public static List<Double> fromString(String value) {
        Type listType = new TypeToken<List<Double>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<Double> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}

