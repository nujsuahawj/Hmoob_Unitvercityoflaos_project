package com.developer.arsltech.fns_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Setweb extends AppCompatActivity {
    private WebView myweb;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setweb);
        myweb = (WebView)findViewById(R.id.setweb);
        WebSettings webSettings = myweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myweb.loadUrl("https://www.nuol.edu.la/index.php/nuol_news");
        myweb.setWebViewClient(new WebViewClient());

    }
    @Override
    public void onBackPressed(){
        if (myweb.canGoBack()){
            myweb.goBack();
        }else {
            super.onBackPressed();
        }

    }//ua kom nws txhob mus tom bormser

}
