package com.developer.arsltech.fns_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Userpost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpost);
    }


    public void Rovqablotomprofile(View view) {
        startActivity(new Intent(getApplicationContext(),Userprofile.class));
    }


    public void thirov(View view) {
        startActivity(new Intent(getApplicationContext(),Userprofile.class));
    }
    public void thin(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
