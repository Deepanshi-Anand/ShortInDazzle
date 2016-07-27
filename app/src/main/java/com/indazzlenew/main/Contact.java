package com.indazzlenew.main;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.indazzlenew.R;

/**
 *
 * Created by user on 27-07-2016.
 */
public class Contact extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_contact);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            assert getSupportActionBar() != null;
            // Enable up icon

            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


}
