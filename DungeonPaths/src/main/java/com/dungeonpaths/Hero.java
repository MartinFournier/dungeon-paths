package com.dungeonpaths;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Hero {
    private String name;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero(String name) {
        setName(name);
    }
}
