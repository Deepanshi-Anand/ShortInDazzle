package com.indazzlenew.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.indazzlenew.R;
import com.indazzlenew.recyclerView.MainProductContent;
import com.indazzlenew.recyclerView.MyProductAdapter;

import java.util.ArrayList;

/**
 * Created by user on 02-07-2016.
 */
public class HomeMain extends Fragment implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    //String prod_names[];
    //String prod_image_urls[];
    private RecyclerView myRecyclerView;
    private MyProductAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog pDialog;
    ArrayList<String> url;

 //   ArrayList Productdata=prepareData();
/*
    private ArrayList prepareData(){
        ArrayList data = new ArrayList<>();
        for(int i=0;i<prod_names.length;i++){
            MainProductContent productContent = new MainProductContent();
            productContent.setProd_name(prod_names[i]);
            productContent.setImage_url(prod_image_urls[i]);
            data.add(productContent);
           }
        return data;
}
*/
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.home_main,container,false);
        //pd=new ProgressDialog(getActivity(),ProgressDialog.STYLE_SPINNER);
        //pd.setMessage("Getting Your Things Ready....");
        //pd.show();
        myRecyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        // use this if changes in content do not change the layout size of the RecyclerView
        myRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new MyProductAdapter(getActivity(),getJSONData());
        myRecyclerView.setAdapter(mAdapter);
       // myRecyclerView.setOnClickListener(this);
        return v;
    }

//returning arraylist for data
   public ArrayList getJSONData(){
       ArrayList<MainProductContent> data=new ArrayList<>();

       int[] icons={R.drawable.ic_menu_camera,R.drawable.ic_menu_gallery,R.drawable.ic_menu_send};
       String[] names={"Product1","Product2","Product3"};
       String[] prices={"245","333","33"};

       //for (int i=0;i<JSONArray.length;i++)
       //{
      // MainProductContent currentContent=new MainProductContent();
      // JSONObject jsonAboutProduct=new JSONObject();
       //currentContent.setId(jsonAboutProduct.getString("id"));
       //currentContent.setName(jsonAboutProduct.getString("name"));
       //currentContent.setPrice(jsonAboutProduct.getInt("price"));
       //data.add(currentContent);
       //}
       ////return data;
       //AboutProduct prodDetails=new AboutProduct();
       //prodDetails.displayDetails();

       for(int i=0;i<names.length;i++)
        {
           MainProductContent current=new MainProductContent();
           current.name=names[i];
           current.pricetemp=prices[i];
           current.prodId=icons[i];
           data.add(current);

        }
        return data;
    }

  /*
    public void connect()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals())
                        else
                       {
                            throw new RuntimeException("api not working")
                       }

                        pDialog.setMessage("Loading...");
                        pDialog.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want

                    }
                });

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        int socketTimeout = 20000;//20 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
    }
    */
    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
