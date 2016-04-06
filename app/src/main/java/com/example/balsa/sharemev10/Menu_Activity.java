package com.example.balsa.sharemev10;

import android.os.Bundle;
import android.widget.Button;


public class Menu_Activity extends global {

    public Button profile_button;
    public Button friends_button;
    public Button create_button;
    public Button list_button;
    public Button settings_button;
    public Button info_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);

        profile_button = (Button) findViewById(R.id.profil_button);
        SetIcon(profile_button, getResources().getString(R.string.fa_profile));

        friends_button = (Button) findViewById(R.id.friends_button);
        SetIcon(friends_button, getResources().getString(R.string.fa_friends));

        create_button = (Button) findViewById(R.id.create_button);
        SetIcon(create_button, getResources().getString(R.string.fa_create));

        list_button = (Button) findViewById(R.id.list_button);
        SetIcon(list_button, getResources().getString(R.string.fa_list));

        settings_button = (Button) findViewById(R.id.settings_button);
        SetIcon(settings_button, getResources().getString(R.string.fa_settings));

        info_button = (Button) findViewById(R.id.info_button);
        SetIcon(info_button, getResources().getString(R.string.fa_info));
    }
}
