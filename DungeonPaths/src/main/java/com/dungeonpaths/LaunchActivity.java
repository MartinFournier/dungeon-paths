package com.dungeonpaths;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.launch_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launch, menu);
        return true;
    }


    public void createHero(View view) {
        EditText text = (EditText) findViewById(R.id.hero_name);
        String heroName = text.getText().toString();
        Hero hero = new Hero(heroName);
        Global.setHero(hero);
        Intent intent = new Intent(this, DungeonActivity.class);

        startActivity(intent);
    }
}
