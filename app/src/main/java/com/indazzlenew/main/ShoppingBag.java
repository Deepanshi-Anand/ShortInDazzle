package com.indazzlenew.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.indazzlenew.R;

/**
 * Created by user on 01-07-2016.
 */
public class ShoppingBag extends AppCompatActivity implements View.OnClickListener  {

    ViewPager pager;
    ViewPagerAdapterShopping adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Cart","WishList"};
    int Numboftabs =2;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_bag);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_shoppingbag);
        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            assert getSupportActionBar() != null;
            // Enable up icon

            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        adapter =  new ViewPagerAdapterShopping(getSupportFragmentManager(),Titles,Numboftabs);
        pager = (ViewPager) findViewById(R.id.pager_shoppingbag);
        pager.setAdapter(adapter);

        // findViewById(R.id.bopendrawer).setOnClickListener(this);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs_shoppingbag);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width



        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);




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
}
