package com.indazzlenew.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.indazzlenew.R;
import com.indazzlenew.main.NavDrawerMain;
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
    public MyProductAdapter(Context context, ArrayList<MainProductContent> data) {

        inflater = LayoutInflater.from(context);
        this.data = data;

    }

  /*
    public void add(int position, MainProductContent item) {
        data.add(position,item);
        notifyItemInserted(position);

    }

    // public void remove(String item) {
    public void remove(MainProductContent item) {
        int position =data.indexOf(item);
        //int position = mDataset.indexOf(item);
        data.remove(position);
        notifyItemRemoved(position);
    }
    */


    @Override
    public MyProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //inflate the xml layout
        View view = inflater.inflate(R.layout.rowproducts, parent, false);
        //pass this root view(linearlayout of xml) to viewholder object
        MyProductViewHolder pvholder = new MyProductViewHolder(view);
        view.setTag(pvholder);
        return pvholder;
        //view LinearLayout is being send to MyProductViewHolder to fetch further view widgets
    }

    @Override
    public void onBindViewHolder(MyProductViewHolder pvholder, int position) {

        //Bean current content object from data list to display current items as we scroll
        MainProductContent current = data.get(position);
        pvholder.name.setText("" + current.name);
        pvholder.price.setText("Rs." + current.pricetemp);
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

    /*
    @Override
    public void onClick(View view) {

    }*/

    //static class
    public class MyProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // save findviewById initialization calls
        ImageView productImage;
        TextView name, price;
        private int id;


        public MyProductViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            //find the textviews and imageview
            productImage = (ImageView) itemView.findViewById(R.id.image_product);
            name = (TextView) itemView.findViewById(R.id.tv1_name1);
            price = (TextView) itemView.findViewById(R.id.tv2_price1);

            //define setOnclickListener methods
            itemView.setOnClickListener(this);

        }


        /* Setter for listener.
           private ClickListener clickListener;
          public void setClickListener(ClickListener clickListener) {
            this.clickListener = clickListener;
               @Override
        public boolean onLongClick(View v) {

            // If long clicked, passed last variable as true.
            clickListener.onClick(v, getPosition(), true);
            return true;
        }
        }*/


        @Override
        public void onClick(View v) {

            int id= v.getId();

            // If not long clicked, pass last variable as false.
            // clickListener.onClick(v, getLayoutPosition(), false);
            Intent i = new Intent(v.getContext(), AboutProduct.class);
            Bundle extras = new Bundle();
           // String c=getAdapterPosition();
            //I/MYMESSage: ViewHolder{2f5c0ea2 position=2 id=-1, oldPos=-1, pLpos:-1}
            String b =v.getTag().toString() ;
            v.getTag().equals("position");
            Log.i("MYMESSage",b);
           // extras.putString("name",mainContent.getName());
            //extras.putString("name", name.toString());
            extras.putString("name", name.getText().toString());
            //extras.putString("price", price.toString());
            extras.putString("price", price.getText().toString());
            extras.putInt("productImage", productImage.getId());
            extras.putInt("productId",id);
            //extras.putInt("productImg",productImage.getResources().getIdentifier("magnify","drawable",context.getPackageName()));
           // extras.putInt("productImgCheck",);
            i.putExtras(extras);
            v.getContext().startActivity(i);


        }




    /*
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


     }
        */
    }
}
