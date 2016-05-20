package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class List_Activity extends global {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);
        GoToBack(List_Activity.this);
        textView = (TextView)findViewById(R.id.list_user_id);
        changText();

    }

    public void changText(){
        TextView textv = (TextView)findViewById(R.id.list_user_id);
        assert textv != null;
        textv.setText("Text Has Been Changed");
        BufferedReader in = null;
        String data = null;

        try{

            HttpClient httpclient = new DefaultHttpClient();

            HttpGet request = new HttpGet();
            URI website = new URI("http://sasa.pluzine.com/balsa/proba.php");
            request.setURI(website);
            HttpResponse response = httpclient.execute(request);
            in = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            // NEW CODE
            String line = in.readLine();
            textv.append(" First line: " + line);
            // END OF NEW CODE

            textv.append(" Connected ");
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
        }
    }


    public void select_events(){

        final String url = "http://sasa.pluzine.com/balsa/proba.php";

        new Thread() {
            @Override
            public void run() {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse response = httpclient.execute(new HttpGet(url));
                    StatusLine statusLine = response.getStatusLine();
                    BufferedReader in = null;
                    in = new BufferedReader(new InputStreamReader(
                            response.getEntity().getContent()));

                    String line = in.readLine();
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
