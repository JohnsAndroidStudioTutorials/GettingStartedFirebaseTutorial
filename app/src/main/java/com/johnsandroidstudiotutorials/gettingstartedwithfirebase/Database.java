package com.johnsandroidstudiotutorials.gettingstartedwithfirebase;

import com.firebase.client.Firebase;

/**
 * Created by John Sarain under Sartain Studios on 9/3/2016.
 */
public class Database extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
