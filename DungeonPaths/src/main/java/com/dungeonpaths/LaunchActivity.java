package com.dungeonpaths;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class LaunchActivity extends Activity {
    private BasicLevel[] levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.launch_main);
        getActionBar().hide();
        levels = BasicLevel.getBasicLevels(getResources());
        ArrayList<String> names = new ArrayList<String>();
        for (BasicLevel level  : levels) {
            names.add(level.getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, names);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        EditText heroName = (EditText) findViewById(R.id.hero_name);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText heroName = (EditText) findViewById(R.id.hero_name);
                Button createButton = (Button) findViewById(R.id.btn_hero);
                if (heroName.getText().toString().length() == 0) {
                    heroName.setError("Hero name is required!");
                    createButton.setEnabled(false);
                } else {
                    heroName.setError(null);
                    createButton.setEnabled(true);
                }
            }
        };
        heroName.addTextChangedListener(textWatcher);
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
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        int index= spinner.getSelectedItemPosition();
        String selectedLevelFile = levels[index].getFile();
        int fileId = Utils.getResourceIdentifier(getResources(), getPackageName(), selectedLevelFile);

        Hero hero = new Hero(heroName);
        Global.setHero(hero);

        Global.setItems(Item.getItems(getResources()));

        Intent intent = new Intent(this, DungeonActivity.class);
        intent.putExtra("FILE_ID", fileId);
        startActivity(intent);
    }
}
