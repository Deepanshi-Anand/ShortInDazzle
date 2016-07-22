package com.indazzlenew.recyclerView;

/**
 * Created by user on 12-07-2016.
 */
public class MainProductContent {

    public int prodId;
    public String pricetemp;
    public String name;
    public int price;
    public String prod_image_url;


    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

   // public int getProdId() {
    //    return prodId;
   // }

    public String getImage_url() {
        return prod_image_url;
    }

    public void setProd_name(String prod_name) {
        this.name = prod_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*public void setProdId(int prodId) {
        this.prodId = prodId;
    }
    */
    public void setImage_url(String prod_image_url) {
        this.prod_image_url = prod_image_url;
    }
}
