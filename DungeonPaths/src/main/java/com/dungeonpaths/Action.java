package com.dungeonpaths;

import com.google.gson.annotations.SerializedName;

import java.util.Random;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Action {
    private String text;
    public String getText() {
        return text;
    }

    @SerializedName("goto")
    private int[] destinations;

    public int getNextEventId() {
        return destinations[new Random().nextInt(destinations.length)];
    }
}
