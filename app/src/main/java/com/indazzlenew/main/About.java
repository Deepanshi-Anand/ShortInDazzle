package com.indazzlenew.main;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.indazzlenew.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 02-07-2016.
 */
public class About extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

   Spinner spinner;
    List<String> categories;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        spinner = (Spinner) findViewById(R.id.spinner_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            assert getSupportActionBar() != null;
            // Enable up icon

            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        categories = new ArrayList<String>();
        categories.add("Terms And Conditions");
        categories.add("Privacy Policy");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
