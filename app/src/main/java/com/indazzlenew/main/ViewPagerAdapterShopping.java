package com.indazzlenew.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.indazzlenew.Fragments.Cart;
import com.indazzlenew.Fragments.WishList;

/**
 * Created by user on 01-07-2016.
 */
public class ViewPagerAdapterShopping extends FragmentStatePagerAdapter {

        CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapterEntry is created
        int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapterEntry is created


        // Build a Constructor and assign the passed Values to appropriate values in the class
        public ViewPagerAdapterShopping(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
            super(fm);

            this.Titles = mTitles;
            this.NumbOfTabs = mNumbOfTabsumb;

        }

        //This method return the fragment for the every position in the View Pager
        @Override
        public Fragment getItem(int position) {

            if (position == 0) // if the position is 0 we are returning the First tab
            {
                //return Login.instantiate(get,Login.class.getName(),null);
                //Login login = Login.newInstance();
                //return login;
                Cart cart=new Cart();
                return cart;


            }

            else         // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
            {
                WishList wishList=new WishList();
                return wishList;
            }

        }




        // This method return the titles for the Tabs in the Tab Strip

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }

        // This method return the Number of tabs for the tabs Strip

        @Override
        public int getCount() {
            return NumbOfTabs;
        }


}
