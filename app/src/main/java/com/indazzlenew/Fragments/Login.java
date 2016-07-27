package com.indazzlenew.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.indazzlenew.main.NavDrawerMain;
import com.indazzlenew.main.ResetPassword;
import com.indazzlenew.R;

import java.util.HashMap;
import java.util.Map;
/*
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.indazzlenew.R;

import java.util.HashMap;
import java.util.Map;

*/

/**
 * Created by my hp on 4/9/2016.
 */

public class Login extends Fragment implements View.OnClickListener {

    ProgressDialog pd;
    String emailPattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[A-Za-z]{2,})$";
    EditText pwd;
    EditText emailValidate;
    String email, password;
    boolean result;
    TextView tv, forgotPassword;
    Button login;
    SharedPreferences user_info;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.login_page, container, false);


        emailValidate = (EditText) v.findViewById(R.id.edtEmail);
        pwd = (EditText) v.findViewById(R.id.edtPassword);

        //user_info = getSharedPreferences("userinfo", 0);
        email = ((EditText) v.findViewById(R.id.edtEmail)).getText().toString();
        // pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //pwd.setTextColor(Color.BLUE);
        password = ((EditText) v.findViewById(R.id.edtPassword)).getText().toString();
        forgotPassword = (TextView) v.findViewById(R.id.bforgotpassword);
        forgotPassword.setOnClickListener(this);

        v.findViewById(R.id.btnLogin).setOnClickListener(this);
        // v.findViewById(R.id.btnSignup).setOnClickListener(this);
        //  findViewById(R.id.btnRegister).setOnClickListener(this);
        pd = new ProgressDialog(getActivity()); // error isAdded() but EntryActivi
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading....");
        return v;
    }
       /*Login newInstance()
       {
        Login log =new Login();
        return log;
       }
       */

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bforgotpassword:
                /*Class cls= null;
                try {
                    cls = Class.forName("com.indazzle.SignUp");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }*/
                Intent fpwd_intent = new Intent(getActivity(), ResetPassword.class);
                startActivity(fpwd_intent);
                break;

            case R.id.btnLogin:
              /*  Class i = null;
                try {
                    i = Class.forName("com.indazzle.NavDrawerMain);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent k = new Intent(getApplicationContext(), i);
                startActivity(k);
                */
                validateDetail();

               // pd.show();
          ///*
                String url = "http:///login.php";
          ///*
                //Creating a string request
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                               // pd.hide();
                                Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
                                // SharedPreferences.Editor edit=user_info.edit();
                                // edit.putString("response",response);
                                //edit.commit();

                                Intent k = new Intent(getActivity(), NavDrawerMain.class);
                                startActivity(k);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //You can handle error here if you want
                                //pd.hide();
                                Toast.makeText(getActivity(), "It's not working", Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //Adding parameters to request
                        params.put("email", email);
                        params.put("password", password);

/*
                        try {
                            JSONObject jsonObject=new JSONObject();
                            jsonObject.put("email",email);
                            jsonObject.put("password",password);
                            params.put("credentials",jsonObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/
                        //returning parameter;

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
//*/

    }



    public boolean validateDetail(){
        String stringDisplay;
        email = emailValidate.getEditableText().toString().trim();
        if(email.matches(emailPattern)&&email.length()!=0&&password!=null&&password.length()>=6)
        {
            result=true;
        }

        if(email.length()==0)
        {
            result =false;
            emailValidate.setError("Email:Required Field");
            //stringDisplay="Email:Required Field";
            //Toast.makeText(getActivity(),stringDisplay,Toast.LENGTH_SHORT).show();
        }
        else if(!email.matches(emailPattern)){
            result = false;
            emailValidate.setError("Invalid Email");
           // stringDisplay = "Invalid Email";
            //Toast.makeText(getActivity(),stringDisplay,Toast.LENGTH_SHORT).show();
        }


        if(password!=null&&pwd.getText().length()<6)
        {
            result =false;
            pwd.setError("Password:Password is too short(minimum is 6 characters)");
            //stringDisplay="Password:Password is too short(minimum is 6 characters)";
            //Toast.makeText(getActivity(),stringDisplay,Toast.LENGTH_SHORT).show();

        }
        else if(password==null)
        {
            result=false;
            pwd.setError("Password :Required field");
            //stringDisplay="Password :Required field";
            //Toast.makeText(getActivity(),stringDisplay,Toast.LENGTH_SHORT).show();
        }

        return result;
    }


}


