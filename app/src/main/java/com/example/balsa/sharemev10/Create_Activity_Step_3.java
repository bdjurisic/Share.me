package com.example.balsa.sharemev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class Create_Activity_Step_3 extends global {

    private int h;
    private int min;
    private String time;
    private String name;
    private String duration;
    private Button button;
    private TimePicker timePicker;

    private int eh;
    private int emin;
    private String etime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__activity__step_3);
        GoToBack(Create_Activity_Step_3.this);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            name = (String) b.get("name");
            h = (int) b.get("h");
            min = (int) b.get("min");
            time = (String) b.get("time");
        }
        button = (Button) findViewById(R.id.event_end_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTime();
                Intent intent = new Intent();
                intent.setClass(Create_Activity_Step_3.this, Create_Activity_Step_4.class);
                intent.putExtra("name", name);
                intent.putExtra("etime", etime);
                intent.putExtra("stime", time);
                intent.putExtra("duration", duration);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

            }
        });


    }


    public void getTime() {
        timePicker = (TimePicker) findViewById(R.id.event_end_time);
        eh = timePicker.getCurrentHour();
        emin = timePicker.getCurrentMinute();
        int x = Math.abs(h - eh);
        int y = Math.abs(min - emin);
        if (h > eh) {
            etime = "Tomorow in: " + Integer.toString(eh) + ":" + Integer.toString(emin)+"h";
            x = 24-x;

        } else if (h == eh) {
            if (min >= emin) {
                etime = "Tomorow in: " + Integer.toString(eh) + ":" + Integer.toString(emin)+"h";
                x = 24-x;
            }
        } else {
            etime = Integer.toString(eh) + ":" + Integer.toString(emin)+"h";
        }
        duration = Integer.toString(x) + ":" + Integer.toString(y);
    }

}
