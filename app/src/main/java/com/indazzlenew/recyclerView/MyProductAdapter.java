package com.indazzlenew.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indazzlenew.R;
import com.indazzlenew.products.AboutProduct;

import java.util.ArrayList;

/**
 * Created by user on 12-07-2016.
 */
public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyProductViewHolder> {

    LayoutInflater inflater;
    ArrayList<MainProductContent> data;

    Context context;


    // constructor of ADAPTER
    public MyProductAdapter(Context context,ArrayList<MainProductContent> data){

        inflater=LayoutInflater.from(context);
        this.data=data;

    }


    @Override
    public MyProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflate the xml layout
       View view= inflater.inflate(R.layout.rowproducts,parent,false);
        //pass this root view(linearlayout of xml) to viewholder object
        MyProductViewHolder pvholder=new MyProductViewHolder(view);
        return pvholder;
    }

    @Override
    public void onBindViewHolder(MyProductViewHolder pvholder, int position) {

        //current content object from data list to display current items as we scroll
        MainProductContent current=data.get(position);
        pvholder.name.setText(""+current.name);
        pvholder.price.setText("Rs."+current.pricetemp);
        pvholder.productImage.setImageResource(current.prodId);


    }

//for image
      //  Picasso.with(context).load(data.get(position).getImage_url()).resize(100,60).into(pvholder.productImage);

        //Uri uri=Uri.parse(current.imageUrl);
        //Context context=pvholder.ItemImage.getContext();
        //Picasso.with(context).load(uri).into(pvholder.ItemImage);
        //Picasso.with(context).load(android_versions.get(i).getProd_image_url()).resize(120, 60).into(pvholder.productimage);


    @Override
    public int getItemCount() {
        return data.size();
    }


   public class MyProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

     ImageView productImage;
     TextView name,price;

     public MyProductViewHolder(View itemView) {
         super(itemView);
         context = itemView.getContext();

         //find the textviews and imageview
         productImage=(ImageView)itemView.findViewById(R.id.image_product);
         name=(TextView)itemView.findViewById(R.id.tv1_name1);
         price=(TextView)itemView.findViewById(R.id.tv2_price1);

         //define setOnclickListener methods

     }

     @Override
     public void onClick(View view) {
         /*Intent intent;
         switch (getPostion()){
             case 0:
                 intent =  new Intent(context,AboutProduct.class);
                 break;

             case 1:
                 intent =  new Intent(context, AboutProduct.class);
                 break;
             case 2:
                 intent =  new Intent(context, AboutProduct.class);
                 break;
         }
         context.startActivity(intent);
     }
     */

     }
 }
}
