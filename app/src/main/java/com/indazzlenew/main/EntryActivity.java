package com.indazzlenew.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.indazzlenew.R;

/**
 * Created by user on 29-06-2016.
 */
public class EntryActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager pager;
    ViewPagerAdapterEntry adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Login","Sign Up"};
    int Numboftabs =2;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_activity);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            assert getSupportActionBar()!=null;
                       // Enable up icon

            ActionBar actionBar=getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

          //  toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_24dp);
          //  toolbar.setNavigationOnClickListener(this);


        }

        adapter =  new ViewPagerAdapterEntry(getSupportFragmentManager(),Titles,Numboftabs);
        pager = (ViewPager) findViewById(R.id.pager_entry);
        pager.setAdapter(adapter);

        // findViewById(R.id.bopendrawer).setOnClickListener(this);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs_entry);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

  */

    }


    @Override
    public void onClick(View view) {


        switch(view.getId())
        {
            case R.id.home:
                onBackPressed();
                break;

        }
    }

    @Override
    public void onBackPressed(){
      Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_login);
       //Icon navigationIcon=(N)toolbar.getNavigationIcon();'
        Intent upIntent=new Intent(this,NavDrawerMain.class);
        NavUtils.navigateUpTo(EntryActivity.this,upIntent);
        // NavUtils.navigateUpFromSameTask(EntryActivity.this);
        //startActivity(in);
    }
    @Override
    public ActionBar getSupportActionBar(){
        return super.getSupportActionBar();
    }


}

