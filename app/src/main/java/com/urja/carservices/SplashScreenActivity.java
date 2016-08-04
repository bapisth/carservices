package com.urja.carservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    // Set Duration of the Splash Screen
    private final  long delay = 5000;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_splash_screen);
        Timer runSplash = new Timer();
        TimerTask showSplashScreen = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                finish();
            }
        };

        runSplash.schedule(showSplashScreen, delay);
    }
}
