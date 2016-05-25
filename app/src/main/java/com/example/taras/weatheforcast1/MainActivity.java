package com.example.taras.weatheforcast1;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.taras.weatheforcast1.fragments.FirstFragment;
import com.example.taras.weatheforcast1.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static final String tag = "project1";

    private MainFragment mainFragment;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        Log.v(MainActivity.tag, sp.getString("cityName", "qwe123").compareToIgnoreCase("wqe123") + "");
        if(sp.getString("cityName","").compareTo("")==0){
            setCurrentFragment( new FirstFragment().newInstance("",""), false);
        }
        else {
            mainFragment = new MainFragment().newInstance(sp.getString("cityName", "London"));
            setCurrentFragment(mainFragment, false);
        }
        Log.v(MainActivity.tag, "create mainAct");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.hide();
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    public void setCurrentFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(MainActivity.tag, "resume mainAct");
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()>0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem mi = menu.add(0, 1, 0, "Preferences");
        mi.setIntent(new Intent(this, prefActivity.class));
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
            //mainFragment.getDB().delAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
