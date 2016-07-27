package com.indazzlenew.recyclerView;

import android.view.View;

/**
 * Created by user on 23-07-2016.
 */
    /* Interface for handling clicks - both normal and long ones. */
    public interface ClickListener {

        /**
         * Called when the view is clicked.
         *
         * @param v view that is clicked
         * @param position of the clicked item
         * @param isLongClick true if long click, false otherwise
         */
        public void onClick(View v, int position, boolean isLongClick);


}
