package com.urja.carservices;

import android.app.Application;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.urja.carservices.utils.CurrentLoggedInUser;

/**
 * Created by BAPI1 on 8/14/2016.
 */

public class CarServiceApplication extends Application {
    private static final String TAG = CarServiceApplication.class.getSimpleName();
    FirebaseAuth mAuth;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
