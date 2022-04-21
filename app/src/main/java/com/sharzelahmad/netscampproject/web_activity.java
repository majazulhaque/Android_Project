package com.sharzelahmad.netscampproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Browser;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class web_activity extends AppCompatActivity {
    WebView webBrowser;
    Button webclick;
    EditText webInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webclick = findViewById(R.id.webClick);
        webInput = findViewById(R.id.webInput);
        webBrowser = findViewById(R.id.webBrowser);

        getSupportActionBar().hide();



        webclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = webInput.getText().toString();

                webBrowser.setWebViewClient(new WebViewClient());
                webBrowser.loadUrl("https://"+s1);

                webBrowser.setWebChromeClient(new WebChromeClient());

                WebSettings webSettings = webBrowser.getSettings();

                webSettings.setJavaScriptEnabled(true);
                webSettings.setPluginState(WebSettings.PluginState.ON);

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (webBrowser.canGoBack()) {
            webBrowser.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

}