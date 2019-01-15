package com.example.clevertapverifyerror;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CleverTapVerifyErrorApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertap = CleverTapAPI.getDefaultInstance(getApplicationContext());
        Log.v(TAG, "got clevertap instance " + clevertap);
    }
}
