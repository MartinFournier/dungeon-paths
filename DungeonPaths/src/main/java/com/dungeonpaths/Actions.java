package com.dungeonpaths;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Actions {
    private String text;

    @SerializedName("goto")
    private int[] destinations;
}
