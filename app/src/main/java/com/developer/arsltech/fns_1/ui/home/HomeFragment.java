package com.developer.arsltech.fns_1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.developer.arsltech.fns_1.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final WebView myweb = root.findViewById(R.id.setweb);

        WebSettings webSettings = myweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myweb.loadUrl("https://nriavtushlubplogteb.000webhostapp.com/andriod/in.html");
        myweb.setWebViewClient(new WebViewClient());

        return root;
    }

}