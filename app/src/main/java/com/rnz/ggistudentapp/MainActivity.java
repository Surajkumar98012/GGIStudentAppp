package com.rnz.ggistudentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView forget_password;
        forget_password = findViewById(R.id.button5);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "ForgetPassword Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, forget_pass.class);
startActivity(intent);
            }
        });
        TextView signup;
        signup = findViewById(R.id.button6);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(MainActivity.this,Home.class);
                startActivity(signuppage);
            }
        });



        //getSupportActionBar().hide();
    }
}