package com.dungeonpaths;

import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class BasicLevel {
    private String file;
    public String getFile() {
        return file;
    }

    private String name;
    public String getName() {
        return name;
    }

    public static BasicLevel[] getBasicLevels(Resources resources) {
        String j = Utils.getJsonString(resources, R.raw.levels);
        Gson gson = new GsonBuilder().create();
        BasicLevel[] l = gson.fromJson(j, BasicLevel[].class);
        return l;
    }

}
