package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile_Activity extends global {

//        private Button profile_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        GoToBack(Profile_Activity.this);
//        profile_back = (Button)findViewById(R.id.profile_back);
//        SetIcon(profile_back,getResources().getString(R.string.fa_back));
//        profile_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GoToPage(Profile_Activity.this,Menu_Activity.class,"b");
//            }
//        });




    }
}
