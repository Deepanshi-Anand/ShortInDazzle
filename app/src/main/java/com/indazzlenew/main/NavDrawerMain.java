package com.indazzlenew.main;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.indazzlenew.Fragments.HomeMain;
import com.indazzlenew.R;

import java.util.Hashtable;
import java.util.Map;

public class NavDrawerMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SearchView.OnQueryTextListener,MenuItem.OnMenuItemClickListener,View.OnClickListener{

    SearchView searchView;
    View headerView;
    TextView nav_user;
    SharedPreferences sharedPreferences;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

          HomeMain p2 = new HomeMain();
          //android.support.v4.app.FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
          FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
          f2.replace(R.id.fragment_container, p2);
          f2.addToBackStack(null);
          f2.commit();



          headerView=navigationView.getHeaderView(0);
          View hView =  navigationView.inflateHeaderView(R.layout.nav_header_nav_drawer);

         // ImageView imgvw = (ImageView)hView.findViewById(R.id.imageView);
          // imgvw.setImageResource();
          nav_user=(TextView)hView.findViewById(R.id.btn_nav_entry);
          nav_user.setOnClickListener(this);

          /*

          Map<String,String> map=new Hashtable<String,String>();
          map.put("hey","hello");
          map.put("hi1","hello");
          map.put("hi2","hello");
          map.put("hi3","hello");
          String result="No Result";
          Intent searchIntent=getIntent();
          if(Intent.ACTION_SEARCH.equals(searchIntent.getAction()))
          {
              String query=searchIntent.getStringExtra(SearchManager.QUERY);
              Log.i("search","query="+query);
              String str=map.get(query);


          }
        */
          //onSearchRequested();


    }

/*
    public void loginInBackground()
    {
      Intent in=new Intent(this,EntryActivity.class);
        startActivity(in);
    }
*/

    @Override
    public void onBackPressed() {
       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {
        //    drawer.closeDrawer(GravityCompat.START);
        //} else {
            super.onBackPressed();
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.nav_drawer, menu);

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.nav_drawer, menu);


            MenuItem searchItem = menu.findItem(R.id.action_search);
              SearchManager searchManager =(SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            searchView.setIconifiedByDefault(false);
             searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setOnQueryTextListener(this);

        /* searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearchRequested();
            }

        });
        */
       // for appearing of search dialog
        // onSearchRequested();

        if (searchView != null) {
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
                //Log.d(TAG,"SearchView not null");
            }

        //SearchManager searchManager1 =(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //ComponentName component=new ComponentName(this,SearchableActivity.class);
        //searchView.setSearchableInfo(searchManager1.getSearchableInfo(component));

        //     MenuItem bagItem=menu.findItem(R.id.action_Bag);
       // bagItem.getItemId()  //onOptionsItemSelected();

            return super.onCreateOptionsMenu(menu);
        }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.action_Bag:
                Intent intent=new Intent(this,ShoppingBag.class);
                startActivity(intent);
        }

        if(item.getTitle().equals("Search"))
        {
            return onSearchRequested();
        }

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
           // Intent in=new Intent(this,MainActivity.class);
            //startActivity(in);
            HomeMain p2 = new HomeMain();
            //android.support.v4.app.FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
            FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
            f2.replace(R.id.fragment_container, p2);
            f2.addToBackStack(null);
            f2.commit();


        }
       // else if (id == R.id.nav_categories) {

       //}
        else if (id == R.id.nav_cart) {
            Intent intent=new Intent(this,ShoppingBag.class);
            startActivity(intent);

        }
        //else if (id == R.id.nav_) {

        //}
        else if (id == R.id.nav_about) {
            Intent intent=new Intent(this, About.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_contact) {
            Intent intent=new Intent(this,Contact.class);
            startActivity(intent);

        }
/*
        else if(id==R.id.btn_nav_entry)
        {
            loginInBackground();
        }

*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   @Override
    public boolean onQueryTextSubmit(String query) {

       // NavUtils.openSearch(SearchableActivity.this,query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public ActionBar getSupportActionBar(){
        return super.getSupportActionBar();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case  R.id.btn_nav_entry:
                Intent in=new Intent(this,EntryActivity.class);
                startActivity(in);


        }


    }
}
