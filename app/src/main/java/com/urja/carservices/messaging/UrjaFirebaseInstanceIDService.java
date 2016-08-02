package com.urja.carservices.messaging;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hemendra on 26-07-2016.
 */
public class UrjaFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = UrjaFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
    }
}
