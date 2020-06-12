package com.androstock.myweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class User_Registration extends AppCompatActivity {

    Button Register;
    EditText et_Enrollment,et_FirstName,et_LastName,et_Email,et_Phone,et_Password,et_Re_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);


        Register = findViewById(R.id.SignUp);
        et_Enrollment = findViewById(R.id.Enrollment);
        et_FirstName = findViewById(R.id.FirstName);
        et_LastName = findViewById(R.id.LastName);
        et_Email = findViewById(R.id.EmailAddress);
        et_Phone = findViewById(R.id.PhoneNo);
        et_Password = findViewById(R.id.Password);
        et_Re_password = findViewById(R.id.Password1);


    }

    public void Register_User()
    {
        StringRequest request= new StringRequest(Request.Method.POST, "https://svnfua.000webhostapp.com/register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.contains("1"))
                        {
                            startActivity(new Intent(getApplicationContext(), User_Login.class));
                        }
                        else if (et_Enrollment.length()==0)
                        {
                            et_Enrollment.requestFocus();
                            et_Enrollment.setError("Enter Enrollment No");
                        }
                        else if (et_FirstName.length()==0)
                        {
                            et_FirstName.requestFocus();
                            et_FirstName.setError("Enter Your First Name");
                        }
                        else if (et_LastName.length()==0)
                        {
                            et_LastName.requestFocus();
                            et_LastName.setError("Enter Your First Name");
                        }
                        else if (et_Email.length()==0)
                        {
                            et_Email.requestFocus();
                            et_Email.setError("Enter Your First Name");
                        }
                        else if (et_Phone.length()==0)
                        {
                            et_Phone.requestFocus();
                            et_Phone.setError("Enter Your First Name");
                        }else if (et_Password.length()==0)
                        {
                            et_Password.requestFocus();
                            et_Password.setError("Enter Your First Name");
                        }else if (et_Re_password.length()==0 || et_Re_password.equals(et_Password))
                        {
                            et_Re_password.requestFocus();
                            et_Re_password.setError("Enter Your First Name");
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Successfully Register",Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("enrollment",et_Enrollment.getText().toString());
                params.put("firstName",et_FirstName.getText().toString());
                params.put("lastName",et_LastName.getText().toString());
                params.put("email",et_Email.getText().toString());
                params.put("Password",et_Password.getText().toString());
                params.put("contactNo",et_Phone.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);

    }

    public void onclick(View view) {
        Register_User();
    }
}


