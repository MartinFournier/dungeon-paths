package com.dungeonpaths;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Item {
    private int id;
    private String level;

    public static Item[] getItems(Resources resources) {
        String j = Utils.getJsonString(resources, R.raw.items);
        Gson gson = new GsonBuilder().create();
        Item[] l = gson.fromJson(j, Item[].class);
        return l;
    }
}
