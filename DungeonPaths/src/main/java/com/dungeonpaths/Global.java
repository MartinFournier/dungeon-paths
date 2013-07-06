package com.dungeonpaths;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Global {
    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        Global.hero = hero;
    }

    private static Hero hero;
}
