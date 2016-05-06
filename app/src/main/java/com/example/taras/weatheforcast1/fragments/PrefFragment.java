package com.example.taras.weatheforcast1.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.taras.weatheforcast1.R;

/**
 * Created by Taras on 02.05.2016.
 */
public class PrefFragment extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }

}
