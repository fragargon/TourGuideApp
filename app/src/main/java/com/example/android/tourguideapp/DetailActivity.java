package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.model.Places;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView titleNameView, itemNameView, webView, telView, addressView, descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /* get intent */
        Intent intent = getIntent();
        Places places = intent.getParcelableExtra("CHOSEN_PLACES");

        /* set variables */
        String titleName = places.getTitleName();
        String itemName = places.getItemName();
        String address = places.getAddress();
        String tel = places.getTel();
        String web = places.getWeb();
        String desc = places.getDesc();
        int image = places.getPhotoId();

        /* Initialize de views */
        titleNameView = findViewById(R.id.detail_title_name);
        titleNameView.setText(titleName);
        itemNameView = findViewById(R.id.detail_item_name);
        itemNameView.setText(itemName);
        addressView = findViewById(R.id.detail_address);
        addressView.setText(address);
        telView = findViewById(R.id.detail_tel);
        telView.setText(tel);
        webView = findViewById(R.id.detail_web);
        webView.setText(web);
        descView = findViewById(R.id.detail_desc);
        descView.setText(desc);
        imageView = findViewById(R.id.detail_image);
        imageView.setImageResource(image);


    }

}
