package com.example.diego.reto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }


    public void click(View v)
    {

        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(i);
    }
}
