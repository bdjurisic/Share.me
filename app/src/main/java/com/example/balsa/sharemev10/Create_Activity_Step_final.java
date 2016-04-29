package com.example.balsa.sharemev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Create_Activity_Step_final extends global {
    private String name;
    private String start;
    private String end;
    private String duration;
    private String describe;

    private TextView t_name;
    private TextView t_start;
    private TextView t_end;
    private TextView t_duration;
    private TextView t_describe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__activity__step_final);
        GoToBack(Create_Activity_Step_final.this);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            name = (String) b.get("name");
            start = (String) b.get("start");
            end = (String) b.get("end");
            duration = (String) b.get("duration");
            describe = (String) b.get("describe");
        }

        t_name = (TextView)findViewById(R.id.event_name_final);
        t_start = (TextView)findViewById(R.id.event_start_final);
        t_end = (TextView)findViewById(R.id.event_end_final);
        t_describe = (TextView)findViewById(R.id.event_describe_final);
        t_duration = (TextView)findViewById(R.id.event_duration_final);

        t_name.setText(name);
        t_start.setText(start);
        t_end.setText(end);
        t_describe.setText(describe);
        t_duration.setText(duration);


    }
}
