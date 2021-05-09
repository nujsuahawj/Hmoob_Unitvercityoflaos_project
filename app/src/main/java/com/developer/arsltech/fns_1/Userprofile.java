package com.developer.arsltech.fns_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Userprofile extends AppCompatActivity {
    ImageView imgblack;
    TextView tv_name,tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);


        imgblack = findViewById(R.id.imgblack);

        tv_name =findViewById(R.id.tv_name);
        tv_address=findViewById(R.id.tv_address);
        SharedPreferences sn=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sn.contains("uname"))
            tv_name.setText(sn.getString("uname",""));//nov yog set tom login lo
        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("upass"))
            tv_address.setText(sp.getString("upass",""));//nov yog set tom login lo

        imgblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgRov();
            }
        });

    }
    private void imgRov() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void Userpost(View view) {
        startActivity(new Intent(getApplicationContext(),Userpost.class));

    }
}
