package com.example.balsa.sharemev10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    private Button button;
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

        button = (Button)findViewById(R.id.event_finish_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEvent("balsa",name,start,end,describe);
                T_message("Successful!");
                GoToPage(Create_Activity_Step_final.this,Menu_Activity.class,"n");
            }
        });

    }

//
    public void insertEvent(String name,String title,String start,String end,String description){

        name = name.replaceAll(" ", "%20");
        title= title.replaceAll(" ", "%20");
        start = start.replaceAll(" ", "%20");
        end = end.replaceAll(" ", "%20");
        description = description.replaceAll(" ", "%20");


        final String url = "http://sasa.pluzine.com/balsa/insertevent.php?name="+name+"&title="+title+"&start="+start+"&end="+end+"&description="+description;
        new Thread() {
            @Override
            public void run() {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse response = httpclient.execute(new HttpGet(url));
                    StatusLine statusLine = response.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        try {
                            response.getEntity().writeTo(out);
                            out.close();
                        } catch (IOException e) {
                        }
                        String responseString = out.toString();
                        //..more logic
                    } else {
                        //Closes the connection.
                        try {
                            response.getEntity().getContent().close();
                            throw new IOException(statusLine.getReasonPhrase());
                        } catch (IOException e) {
                        }
                    }
                }
                catch (ClientProtocolException e)
                {

                }
                catch (IOException e)
                {

                }
            }
        }.start();
    }

}
