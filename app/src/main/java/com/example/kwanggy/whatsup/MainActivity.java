package com.example.kwanggy.whatsup;

//import android.app.ListActivity;
//import android.content.ComponentName;
//import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int wait = 1 * 1000;// wait this many milliseconds before moving on to next activity
        // Note: make sure this is set to a proper number when demonstrating

        Timer clock = new Timer();
        clock.schedule(new TimerTask() {
            public void run() {
                startActivity(new Intent(getApplicationContext(), com.example.kwanggy.whatsup.ListActivity.class));
                finish();
            }
        }, wait);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
