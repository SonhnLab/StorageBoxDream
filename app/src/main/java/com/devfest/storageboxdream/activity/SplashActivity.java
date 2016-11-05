package com.devfest.storageboxdream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.devfest.storageboxdream.R;

/**
 * Created by SonhnLab on 11/6/2016.
 */

public class SplashActivity extends AppCompatActivity {

    //region Properties

    private static int SPLASH_TIME_OUT = 4000;

    //endregion

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
