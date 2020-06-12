package com.androstock.myweatherapp;

import android.app.Dialog;
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

public class User_Login extends AppCompatActivity {


    Button btn_login;
    EditText et_username,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);


        btn_login = findViewById(R.id.button_login);

        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Home_Weather.class));
            }
        });


    }


    public void onclick(View view) {
        startActivity(new Intent(getApplicationContext(),User_Registration.class));
    }
}
