package com.example.taras.weatheforcast1;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Taras on 04.05.2016.
 */
public class prefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}
