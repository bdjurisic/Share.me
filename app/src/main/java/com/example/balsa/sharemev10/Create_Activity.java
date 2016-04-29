package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Create_Activity extends global {

    /**
     * next dugme koje kupi indormaciju o imenu eventa
     */
    private Button next;

    /**
     * editText je polje u koje unosimo naziv evenata
     */
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_);
        GoToBack(Create_Activity.this);

        editText = (EditText)findViewById(R.id.event_name);

        next = (Button)findViewById(R.id.event_next_1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editText.getText().toString();

                if(name.equals(""))
                {
                    T_message("Event name must be field");
                }
                else if(name.length()>150){
                    T_message("Event name can have 150 characters");
                    editText.setText("");
                }
                else if(name.substring(name.length()-1,name.length()).equals("~"))
                {
                    T_message("Event name can not end with this \"~\" character");
                    editText.setText("");
                }
                else if(isValidFormat(name,"~"))
                {
                    T_message("Event name can not have this \"~\" character");
                    editText.setText("");
                }
                else{
                    GoToPageWithExtras(Create_Activity.this,Create_Activity_Step_2.class,"n",name);
                }
            }
        });

    }


}
