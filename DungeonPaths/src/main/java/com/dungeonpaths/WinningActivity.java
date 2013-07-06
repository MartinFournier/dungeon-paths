package com.dungeonpaths;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WinningActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winning_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.winning, menu);
        return true;
    }
    
}
