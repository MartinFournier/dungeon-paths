package com.dungeonpaths;

import java.util.ArrayList;

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

    private static Item[] items;
    public static void setItems(Item[] allItems) {
        items = allItems;
    }
    public static Item[] getItems(){
        return items;
    }

    public static void receiveItem(ItemReward item) {
        Global.receiveItem(item);
    }
}
