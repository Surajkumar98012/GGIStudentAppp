package com.rnz.ggistudentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class forget_pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        TextView signup;
        signup = findViewById(R.id.registerbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forget_pass_page = new Intent(forget_pass.this,verification_code.class);
                startActivity(forget_pass_page);
            }
        });

        //getSupportActionBar().hide();
    }
}