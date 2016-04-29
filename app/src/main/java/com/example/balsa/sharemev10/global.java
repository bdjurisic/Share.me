package com.example.balsa.sharemev10;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class global extends AppCompatActivity {

    /**
     * Method GoToPage goes from current to next page
     *
     * @param this_page     Current page (Activity.this)
     * @param next_page     Next page (Activity.class)
     * @param type_of_slide Slide animation n for next or b for back
     */
    public void GoToPage(Activity this_page, Class next_page, String type_of_slide) {
        Intent intent = new Intent();
        intent.setClass(this_page, next_page);
        startActivity(intent);
        if (type_of_slide.equals("b")) {
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        if (type_of_slide.equals("n")) {
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }


    /**
     * Method GoToPageWithExtras goes to next page with put extra function in it.
     *
     * @param this_page     Activity      current page(Activity.this)
     * @param next_page     Class         next page(Activity.class)
     * @param type_of_slide String    slide n for next or b for back
     * @param extra         String            string for put extra argument
     */
    public void GoToPageWithExtras(Activity this_page, Class next_page, String type_of_slide, String extra) {
        Intent intent = new Intent();
        intent.setClass(this_page, next_page);
        intent.putExtra("string", extra);
        startActivity(intent);
        if (type_of_slide.equals("b")) {
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        if (type_of_slide.equals("n")) {
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }

    }


    /**
     * SetIcon  method set the icon from fontawesome instead of text,
     * icons can find on font-awesome site and find a code for each icon,
     * format of code you need to use is like uf111, in this situation the codes
     * of icon are stored into the res/string.xml with name fa_....
     *
     * @param b    Button
     * @param icon String   Icon (uf001)
     */
    public void SetIcon(Button b, String icon) {

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        b.setTypeface(tf);
        b.setText(icon);
    }


    /**
     * Method finding every button whit id _back and set a paht and icon for back to menu page
     */
    public void GoToBack(final Activity this_page) {
        Button back = (Button) findViewById(R.id._back);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        back.setTypeface(tf);
        back.setText(getResources().getString(R.string.fa_back));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(this_page, Menu_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });
    }


    /**
     * Method t_message drawing a toast with a string s for a long length of time which is default by android app
     *
     * @param s String  Message for toast
     */
    public void T_message(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


    public boolean isValidFormat(String line, String pattern) {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            return true;
        } else {
            return false;
        }

    }
}
