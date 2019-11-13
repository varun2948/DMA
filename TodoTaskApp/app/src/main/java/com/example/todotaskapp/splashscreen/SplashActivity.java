package com.example.todotaskapp.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.todotaskapp.MainActivity;
import com.example.todotaskapp.R;
import com.example.todotaskapp.common.Constants;
import com.example.todotaskapp.common.SharedPreferenceUtils;
import com.example.todotaskapp.walkthrough.WalkThroughSliderActivity;

public class SplashActivity extends Activity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        final Animation a = AnimationUtils.loadAnimation(this, R.anim.shake);
        a.reset();
        final TextView rText = (TextView) findViewById(R.id.textSplash);
        rText.startAnimation(a);


        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SharedPreferenceUtils.getInstance(SplashActivity.this).getBoolanValue(Constants.isFirstTime, false)){

                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Intent intent = new Intent(SplashActivity.this, WalkThroughSliderActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3000);

    }
}