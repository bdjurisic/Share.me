package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.widget.Button;

public class Friends_Activity extends global {
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_);
        GoToBack(Friends_Activity.this);
    }
}
