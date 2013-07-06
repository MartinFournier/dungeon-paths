package com.dungeonpaths;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

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

    @SerializedName("victory_events")
    private int[] victoryEventsId;

    @SerializedName("first_event")
    private int firstEventId;

    private Event[] events;
    public Event[] getEvents() {
        return events;
    }


    private Event currentEvent;

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public boolean isVictory() {
        if (currentEvent == null) return false;

        int currentId = currentEvent.getId();
        for (int id : victoryEventsId){
            if (id == currentId) return true;
        }

        return false;
    }

    public static Level getLevel(Resources resources, int file) {
        String j = Utils.getJsonString(resources, R.raw.level1);
        Gson gson = new GsonBuilder().create();
        Level l = gson.fromJson(j, Level.class);
        l.init();
        return l;
    }

    public void init() {
        currentEvent = getEventById(firstEventId);
    }

    public void setEventById(int id){
        currentEvent = getEventById(id);
    }

    private Event getEventById(int id){
        for (Event e : events) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
