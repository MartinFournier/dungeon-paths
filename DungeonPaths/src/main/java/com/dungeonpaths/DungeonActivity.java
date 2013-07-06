package com.dungeonpaths;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DungeonActivity extends Activity {
    private Level level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungeon_main);
        this.level = Level.getLevel(getResources(), R.raw.level1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dungeon, menu);
        return true;
    }
    
}
