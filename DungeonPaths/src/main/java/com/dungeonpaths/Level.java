package com.dungeonpaths;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Level {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int[] victoryEvents;
    private int startingEvent;

    public static Level getLevel(Resources resources, int file) {
        String j = Utils.getJsonString(resources, R.raw.level1);
        Gson gson = new GsonBuilder().create();
        Level l = gson.fromJson(j, Level.class);
        return l;
    }
}
