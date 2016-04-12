package com.example.balsa.sharemev10;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class global extends AppCompatActivity {

    /**
     * Prelazak iz aktivitija u aktiviti
     *
     * @param this_page     Trenutna stranica na kojoj smo sada
     * @param next_page     Sledeca stranica odnosno stranica na koju treba da idemo
     * @param type_of_slide Tip slidera da li ce da ide unazad ili naprijed
     *                      ako ide iz lijeve u desnu stranu onda je "n"
     *                      ako ide iz desne u lijevu onda je "b"
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
     * SetIcon postavlja ikonicu sa Font Avesome umjesto texta
     * smejsteni su u assete i ja sam ih smjestio u string odvojeno ove sto su potrebni
     * a pisu se kao uf111   u mora ostalo f111 je code od ikonice
     *
     * @param b    Dugme kojem zelimo da stavimo ovo cudo
     * @param icon String ikonice koju zleimo da stavimo kao npr. uf001
     */
    public void SetIcon(Button b, String icon) {

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        b.setTypeface(tf);
        b.setText(icon);
    }


}
