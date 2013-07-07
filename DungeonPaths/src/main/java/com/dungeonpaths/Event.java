package com.dungeonpaths;

/**
 * Created by fourn_000 on 06/07/13.
 */
public class Event {
    private int id;

    public int getId() {
        return this.id;
    }

    private String text;
    public String getText() {
        return text;
    }

    private String place;
    public String getPlace(){
        return place;
    }

    private Action[] actions;
    public Action[] getActions() {
        return actions;
    }

    private ItemReward item;
    public ItemReward getItem(){
        return item;
    }
}
