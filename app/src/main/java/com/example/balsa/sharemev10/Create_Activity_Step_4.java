package com.example.balsa.sharemev10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Create_Activity_Step_4 extends global {

    private String name;
    private String start;
    private String end;
    private String duration;
    private Button button;
    private EditText editText;
    private String describe_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__activity__step_4);
        GoToBack(Create_Activity_Step_4.this);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            name = (String) b.get("name");
            start = (String) b.get("stime");
            end = (String) b.get("etime");
            duration = (String) b.get("duration");

        }
        editText = (EditText)findViewById(R.id.event_describe);
        describe_text = editText.getText().toString();
        if(describe_text.equals(""))
        {
            describe_text = "No describe";
        }
        button= (Button)findViewById(R.id.event_describe_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Create_Activity_Step_4.this, Create_Activity_Step_final.class);
                intent.putExtra("name", name);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                intent.putExtra("duration", duration);
                intent.putExtra("describe", describe_text);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }
}
