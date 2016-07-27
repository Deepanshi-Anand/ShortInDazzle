package com.indazzlenew.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.indazzlenew.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 30-06-2016.
 */
public class SignUp extends Fragment implements View.OnClickListener {

    EditText edtFname, edtLname, edtemail, edtPass, edtNo;
    String fname, lname, emailSign, mobno, pwdSign;
    ProgressDialog pd;
    String emailPattern;
    long pnoi;
    SharedPreferences sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.signup_page, container, false);
        edtemail = (EditText) v.findViewById(R.id.email_sign);
        edtPass = (EditText) v.findViewById(R.id.pwd_sign);
        edtFname = (EditText) v.findViewById(R.id.fname_sign);
        edtLname = (EditText) v.findViewById(R.id.lname_sign);
        edtNo = (EditText) v.findViewById(R.id.mobile_sign);

        fname = (edtFname).getText().toString();
        lname = (edtLname).getText().toString();
        emailSign = (edtemail).getText().toString();
        mobno = (edtNo).getText().toString();
        pwdSign = (edtPass).getText().toString();

/*
        fname = ((EditText) v.findViewById(R.id.fname_sign)).getText().toString();
        lname = ((EditText) v.findViewById(R.id.lname_sign)).getText().toString();
        emailSign = ((EditText) v.findViewById(R.id.email_sign)).getText().toString();
        mobno = ((EditText) v.findViewById(R.id.mobile_sign)).getText().toString();
        pwdSign = ((EditText) v.findViewById(R.id.pwd_sign)).getText().toString();
*/
        v.findViewById(R.id.btnSignUp).setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {



        switch (view.getId()) {
            case R.id.btnSignUp:
                boolean result;
                validateUserDetails();
                //result= validateUserDetails();

                //Class i = null;
                //try {
                //    i = Class.forName("com.indazzlenew.main.NavDrawerMain");
                //} catch (ClassNotFoundException e) {
                //    e.printStackTrace();
                //}
                //Intent k = new Intent(getActivity(), i);
                //startActivity(k);
                //break;


                //    pd.show();
                // fname = ((EditText) findViewById(R.id.fname_sign)).getText().toString();
                //lname = ((EditText) findViewById(R.id.lname_sign)).getText().toString();
                //username = ((EditText) findViewById(R.id.sign_email)).getText().toString();

                //sp = getSharedPreferences("user", 0);
                //SharedPreferences.Editor editor = sp.edit();
                //editor.putString("fname",fname);
                //editor.putString("lname",lname);
                //editor.commit();

                //emailSign = ((EditText) findViewById(R.id.email_sign)).getText().toString();
                // pwdSign = ((EditText) findViewById(R.id.pwd_sign)).getText().toString();
                //confirmpass = ((EditText) findViewById(R.id.edit_signup_confirmpass)).getText().toString();
                ///*if(!password.equals(confirmpass)){
                //  showerror();
                //break; }

                //try {
                //   validateUserDetails();
                //}
                //catch(Exception e)
                //{
                // e.printStackTrace();
                //}
                // score=Long.parseLong(((EditText)findViewById(R.id.email_sign)).getText().toString());
            /*
                try {
                    // mobno = ((EditText) findViewById(R.id.mobile_sign)).getText().toString();

                    if (mobno.length() != 10) {
                        //pd.hide();
                        Toast.makeText(getActivity(), "Incorrect Mobile number length", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    pnoi = Long.parseLong(mobno);

                } catch (NumberFormatException n) {
                    //pd.hide();
                    Toast.makeText(getActivity(), "Incorrect Mobile number", Toast.LENGTH_SHORT).show();
                    break;
             */

                //RequestQueue queue = Volley.newRequestQueue(this);}

                // mobno=((EditText)findViewById(R.id.mobile_Sign)).getText().toString();

                //if (result == true) {
                    String url = "http://.php";


              /*
                    JSONObject obj=new JSONObject();
                try {
                    obj.put("firstname",fname);
                    obj.put("lastname",lname);
                    obj.put("email",emailSign);
                    obj.put("password",pwdSign);
                    obj.put("pno",mobno);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


// Request a string response from the provided URL.
                JsonObjectRequest jsObjRequest = null;

                jsObjRequest = new JsonObjectRequest
                        (Request.Method.POST, url,obj, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                //try {
                                    //mTextView.setText(response.getString("respMsg"));
                             //   } catch (JSONException e) {
                                 //   e.printStackTrace();
                             //   }
                                Toast.makeText(getActivity(),"its working"+response.toString(),Toast.LENGTH_LONG).show();
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub
                                Toast.makeText(getActivity(),"its not working",Toast.LENGTH_LONG).show();
                            }


                        })
                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type","application/json;charset=utf-8");
                        params.put("Accept", "application/json");

                        return params;
                    }
                };

                int socketTimeout = 7000;//30 seconds - change to what you want
                RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                jsObjRequest.setRetryPolicy(policy);


// Add the request to the RequestQueue.
                if(jsObjRequest!=null)
                    queue.add(jsObjRequest);
                break;
        }

        */
                    //Creating a string request


                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //pd.hide();
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                    Class i = null;
                                    try {
                                        i = Class.forName("com.indazzle.main.Login");
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    Intent k = new Intent(getActivity(), i);
                                    startActivity(k);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //You can handle error here if you want
                                    //pd.hide();

                                    Toast.makeText(getActivity(), "its not working" + error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put("fname", fname);
                            params.put("lname", lname);
                            params.put("email", emailSign);
                            params.put("password", pwdSign);
                            params.put("mobile", mobno);
                            //params.put("username", username);

                            //returning parameter
                            return params;
                        }
                    };

                    //Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                    requestQueue.add(stringRequest);


                    int socketTimeout = 20000;//20 seconds - change to what you want
                    RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    stringRequest.setRetryPolicy(policy);
                    break;
                }

      //  }
        // private void showerror() {
        //    pd.hide();
        //    Toast.makeText(SignUp.this,"password mismatch",Toast.LENGTH_LONG).show();

        // }


        // */

    }

    public boolean validateUserDetails() {
        String stringDisplay;
        String selector;
        boolean result;
        emailSign = edtemail.getEditableText().toString().trim();
        emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (edtFname.getText().length() != 0) {
            if (edtFname.getText().length() > 100) {
                result = false;
                edtFname.setError("First Name exceeded Limit");
               // stringDisplay = "First Name exceeded Limit";
                //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
                return result;
            }
        } else if (edtLname.getText().length() != 0) {
            if (edtLname.getText().length() > 100) {
                result = false;
                edtLname.setError("Last Name exceeded Limit");
               // stringDisplay = "Last Name exceeded Limit";
                //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
                return result;
            }
        } else if ((!(edtemail.getText().length() == 0)) && (!emailSign.matches(emailPattern))) {
            result = false;
            edtemail.setError("Invalid Email");
            return result;
        }
        else if (edtPass.getText().length()!=0)
        {

            if ((edtPass.getText().length())<=5) {
                result = false;
                edtPass.setError("Password:Password is too short(minimum is 6 characters)");
                return result;
            }
        }
         else if (edtNo.getText().length() != 0) {
            String mobilePattern = "^[7-9]\\d{9}$";
            if (!mobno.matches(mobilePattern)) {
                result = false;
                edtNo.setError("Invalid Mobile No.");
                //stringDisplay = "Invalid Mobile No.";
                //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
                return result;
            }
        }


         if (edtFname.getText().length() <= 0) {
            result = false;
             edtFname.setError("First Name :Required field");
            //stringDisplay = "First Name :Required field";
            //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
            return result;
        } else if (edtLname.getText().length() == 0) {
            result = false;
             edtLname.setError("Last Name :Required field");
            //stringDisplay = "Last Name :Required field";
            //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
            return result;
        }
         else if (edtemail.getText().length() == 0) {
            result = false;
             edtemail.setError("Email:Required Field");
            //stringDisplay = "Email:Required Field";
            //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
        } else if (pwdSign == null) {
            result = false;
             edtPass.setError("Password :Required field");
            //stringDisplay = "Password :Required field";
            //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
            return result;
        } else if (edtNo.getText().length() == 0) {
            result = false;
             edtNo.setError("Mobile No.:Required field");
            //stringDisplay = "Mobile No.:Required field";
            //Toast.makeText(getActivity(), stringDisplay, Toast.LENGTH_SHORT).show();
            return result;
          }


        result=true;
        return result;


    }
}









