package com.indazzlenew.products;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.indazzlenew.main.ShoppingBag;
import com.indazzlenew.R;

/**
 * Created by user on 02-07-2016.
 */
public class AboutProduct extends AppCompatActivity {


    Context context;
    Toolbar toolbar;
    ImageView imgAboutProduct;
    TextView tvPrice,tvAbout,tvMore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_description);

        imgAboutProduct=(ImageView)findViewById(R.id.product_desc_image);
        tvPrice=(TextView)findViewById(R.id.tvproduct_desc_price);
        tvAbout=(TextView)findViewById(R.id.tvproduct_desc_about);
        tvMore=(TextView)findViewById(R.id.tvproduct_desc_moreinfo);
        toolbar= (Toolbar) findViewById(R.id.toolbar_aboutproduct);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            assert getSupportActionBar() != null;
            // Enable up icon
            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
         }

        String ProductName;
        int ProdImage;
        String Prodprice;
        //Bundle savedInstanceState;
        Intent intent=getIntent();
        savedInstanceState=intent.getExtras();
         /*if(intent.hasExtra("name"))
         {
         */
        // String ProductName=intent.getStringExtra("name");
        ProductName=savedInstanceState.getString("name");
        //ProdImage=intent.getIntExtra("productImage",imgAboutProduct.getId());
        ProdImage=intent.getIntExtra("productImg",imgAboutProduct.getId());
        Prodprice=intent.getStringExtra("price");
        //}
//        imgAboutProduct.setImageResource(ProdImage);
        tvPrice.setText(Prodprice);
        tvAbout.setText(ProductName);

    }

    //Constructor
    public AboutProduct()
    {

    }

 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.product_toolbar, menu);

        MenuItem bagItem=menu.findItem(R.id.action_product_Bag);
        MenuItem settings=menu.findItem(R.id.action_settings);

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

        //noinspection SimplifiableIfStatement
        case  R.id.action_settings:
           return false;
        }


        return super.onOptionsItemSelected(item);
    }

}
