package com.indazzlenew.main;

import android.app.DownloadManager;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.indazzlenew.R;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by user on 30-06-2016.
 */
public class SearchableActivity extends AppCompatActivity {

   String result;
    TextView textView;
    LinearLayout ly1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_whole);
         Log.d("Search","HERE");
         //setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);

        textView=(TextView)findViewById(R.id.textview_search);
        ly1=(LinearLayout)findViewById(R.id.ly1_search);
        Map<String,String> map=new Hashtable<String,String>();
        map.put("hey","hello");
        map.put("hi1","hello");
        map.put("hi2","hello");
        map.put("hi3","hello");
        String result="No Result";
        handleIntent(getIntent(),map);
        /*Intent searchIntent=getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction()))
        {
            String query=searchIntent.getStringExtra(SearchManager.QUERY);
            Log.i("search","query="+query);
            String str=map.get(query);
        }
       */

    }

    private void handleIntent(Intent intent,Map map)
    {
        if(Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query=intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query,map);
        }
    }
/*
    public void onNewIntent(Intent intent,Map map)
    {
        setIntent(intent);
        handleIntent(intent,map);

    }
*/
     public void doMySearch(String query,Map map)
    {
        Log.i("search","query="+query);
        String str= (String) map.get(query);
        if(str!=null)
        {
            result="result"+query+"is"+str;
        }

        textView.setText(result);
    }
}