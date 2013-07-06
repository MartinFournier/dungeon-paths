package com.dungeonpaths;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DungeonActivity extends Activity {
    private Level level;
    private ArrayList<Button> levelButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungeon_main);
        this.level = Level.getLevel(getResources(), R.raw.level1);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(Global.getHero().getName());
        actionBar.setSubtitle(level.getName());
        showCurrentEvent();
    }

    View.OnClickListener getOnClickChangeEvent(final int eventId)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                level.setEventById(eventId);
                showCurrentEvent();
            }
        };
    }

    private void showCurrentEvent() {
        if (level.isVictory()){
            Intent intent = new Intent(this, WinningActivity.class);
            startActivity(intent);
        }

        if (levelButtons != null) {
            for (Button button : levelButtons) {
                ViewGroup layout = (ViewGroup) button.getParent();
                if(null!=layout) //for safety only  as you are doing onClick
                    layout.removeView(button);
            }
        }

        TextView textView = (TextView)findViewById(R.id.main_text);
        Event currentEvent = level.getCurrentEvent();
        textView.setText(currentEvent.getText());

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 20);

        ArrayList<Button> buttons = new ArrayList<Button>();

        Action[] actions = currentEvent.getActions();
        if (actions != null){
            for (Action action : actions){
                Button button = new Button(this);
                button.setText(action.getText());
                button.setLayoutParams(params);
                button.setPadding(30, 10, 30, 10);
                button.setTextSize(20);
                button.setOnClickListener(getOnClickChangeEvent(action.getNextEventId()));
                layout.addView(button);
                buttons.add(button);
            }
        }

        levelButtons = buttons;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dungeon, menu);
        return true;
    }
    
}
