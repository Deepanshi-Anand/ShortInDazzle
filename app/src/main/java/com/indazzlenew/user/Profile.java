package com.indazzlenew.user;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
import com.indazzlenew.R;

/**
 * Created by user on 19-07-2016.
 */
public class Profile extends AppCompatActivity implements View.OnClickListener{

    Context context;
    EditText userName;
    String str;
    String usernameProfile;
    TextView letterText;
    EditText dateText;

    DatePickerDialog.OnDateSetListener date;
    // DatePickerDialog datePickerDialog;
    java.util.Calendar myCalendar;
    int _day,_year,_month;
    Toolbar toolbar;

    //constructor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        //initializeVariables();
        userName=(EditText)findViewById(R.id.et_profile_username);
        dateText=(EditText)findViewById(R.id.et_profile_dob);
        toolbar=(Toolbar)findViewById(R.id.toolbar_user_prof);
        letterText=(TextView)findViewById(R.id.tv_letterName);


        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

     /*
        //After Login occurs
        try{
        usernameProfile=userName.getText().toString();
        str=new char[2];
        usernameProfile.getChars(0,1,str,0);
        letterText.setText( str.toString().toUpperCase());
        letterText.setTextColor(Color.BLACK);
        }catch(IndexOutOfBoundsException e)
        {
           e.printStackTrace();
        }
     */
           //userName.onEditorAction();
  /*
        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (userName.getText().toString() != null) {
                    usernameProfile = userName.getText().toString();
                    str = String.valueOf(usernameProfile.charAt(0)).toUpperCase();
                    letterText.setText(str);
                    letterText.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
*/
        //datePickerDialog=new DatePickerDialog(this);
        //datePickerDialog.OnDateSetListener(){
        //}
        // new DatePickerDialog.OnDateSetListener() {
        //@Override
        //public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            //_day = dayOfMonth;
            //_month = monthOfYear;
            //_year = year;
            // myCalendar.set(year,monthOfYear,dayOfMonth);
            //  displayDate();
         //  }
    //}
                //
                // , myCalendar.get(java.util.Calendar.YEAR),myCalendar.get(java.util.Calendar.DAY_OF_MONTH),
               // myCalendar.get(java.util.Calendar.DAY_OF_MONTH)
              // );
                // myCalendar= java.util.Calendar.getInstance();
         date=new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
               _day=dayOfMonth;
               _month=monthOfYear;
               _year=year;
               // myCalendar.set(year,monthOfYear,dayOfMonth);
                displayDate();
             }
          };
        dateText.setOnClickListener(this);

  }


    private void initializeVariables()
    {


    }

    public void displayDate(){
        String dateFormat="MM/dd/yy";
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat(dateFormat,Locale.US);
        dateText.setText(new StringBuilder().append(_day).append("/").append(_month+1).append("/").append(_year));
        //dateText.setText(sdf.format(myCalendar.getTime()));
    }
    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.et_profile_dob:
                   //DatePickerDialog datePickerDialog=new DatePickerDialog(this);
                  DatePickerDialog datePickerDialog=new DatePickerDialog(Profile.this,date,2016,7,8);
                  datePickerDialog.show();
        }
    }
    /*
    ProfileImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Dialog dialog = new Dialog(PersonalDetailsActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.add_image_dialog);
            dialog.getWindow().setLayout(width, 200);
            ImageView camera = (ImageView) dialog.findViewById(R.id.extra_order_history_camera);
            ImageView sdCard = (ImageView) dialog.findViewById(R.id.extra_order_history_sdcard);
            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                    dialog.dismiss();
                }
            });
            sdCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, SELECT_FILE);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    });
    }
    */

}
