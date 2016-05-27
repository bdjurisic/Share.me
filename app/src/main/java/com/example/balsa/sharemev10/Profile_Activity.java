package com.example.balsa.sharemev10;

import android.os.Bundle;

public class Profile_Activity extends global {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        GoToBack(Profile_Activity.this);
    }
}
