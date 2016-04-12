package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Friends_Activity extends global {
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_);
        b = (Button)findViewById(R.id.fiends_page_back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToPage(Friends_Activity.this,Menu_Activity.class,"b");
            }
        });
    }
}
