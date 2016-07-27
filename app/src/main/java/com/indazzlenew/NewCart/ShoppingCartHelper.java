package com.indazzlenew.NewCart;

/**
 * Created by user on 26-07-2016.
 */
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Vector;

 import android.content.Context;
 import android.content.res.Resources;
 import android.support.v4.content.ContextCompat;
 import android.support.v4.content.res.ResourcesCompat;
 import android.support.v7.app.AppCompatActivity;

 import com.indazzlenew.R;
 import com.indazzlenew.recyclerView.MainProductContent;

public class ShoppingCartHelper extends AppCompatActivity{

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;
    public ArrayList<MainProductContent> data;
    private static Context context;

    public static List<Product> getCatalog(Resources res){
        MainProductContent item;
        if(catalog == null) {
            catalog = new Vector<Product>();
            //not correct
            // catalog.add(new Product("Do ", getResources().getDrawable(context, R.drawable.ic_menu_send),
            // "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            catalog.add(new Product("Do ", ContextCompat.getDrawable(context, R.drawable.ic_menu_send),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
             //catalog.add(new Product("Do ", ResourcesCompat.getDrawable(res,R.drawable.ic_menu_send, context.getTheme()),
              //     "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            // catalog.add(new Product("Do ", ResourcesCompat.getDrawable(res,R.drawable.ic_menu_camera, Resources.Theme.)));
            //        "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            catalog.add(new Product("Switch",ResourcesCompat.getDrawable(res,R.drawable.ic_menu_gallery, context.getTheme()),
                    "Switch by Chip Heath and Dan Heath", 24.99));
            catalog.add(new Product("Watchmen", ResourcesCompat.getDrawable(res,R.drawable.ic_menu_camera, null),
                    "Watchmen by Alan Moore and Dave Gibbons", 14.99));
        }

        return catalog;
    }

    public static List<Product> getCart() {
        if(cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }

}
