package com.indazzlenew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indazzlenew.R;

/**
 * Created by user on 01-07-2016.
 */
public class Cart extends Fragment implements View.OnClickListener{

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cart_page, container, false);




        return v;
    }


    @Override
    public void onClick(View view) {

    }
}
