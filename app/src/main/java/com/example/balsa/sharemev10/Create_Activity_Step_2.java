package com.example.balsa.sharemev10;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Create_Activity_Step_2 extends global {

    private Button button;
    private TimePicker timePicker;
    private int h;
    private int min;
    private String time;
    private String name;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__activity__step_2);
        GoToBack(Create_Activity_Step_2.this);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            name = (String) b.get("string");

        }
        button = (Button) findViewById(R.id.event_start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTime();
                Intent intent = new Intent();
                intent.setClass(Create_Activity_Step_2.this, Create_Activity_Step_3.class);
                intent.putExtra("name",name);
                intent.putExtra("h",h);
                intent.putExtra("min",min);
                intent.putExtra("time",time);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });
    }
    public void getTime() {
        timePicker = (TimePicker) findViewById(R.id.event_start_time);
        h = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();
        time = Integer.toString(h)+ ":"+Integer.toString(min)+"h";
    }

}
