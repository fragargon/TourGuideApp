package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Places places;

    private int CATEGORY_ID = 1;
    private String CATEGORY_NAME = "";
    private int INDEX = 0;

    ImageView imageView;
    TextView titleNameView, itemNameView, webView, telView, addressView, descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get intent
        CATEGORY_ID = getIntent().getExtras().getInt("categoryId");
        CATEGORY_NAME = getIntent().getExtras().getString("categoryName");
        INDEX = getIntent().getExtras().getInt("index");

        // set data
        getData();

        titleNameView = findViewById(R.id.detail_title_name);
        titleNameView.setText(places.getTitleName());
        imageView = findViewById(R.id.detail_image);
        imageView.setImageResource(places.getPhotoId());
        itemNameView = findViewById(R.id.detail_item_name);
        itemNameView.setText(places.getItemName());
        webView = findViewById(R.id.detail_web);
        webView.setText(places.getWeb());
        telView = findViewById(R.id.detail_tel);
        telView.setText(places.getTel());
        addressView = findViewById(R.id.detail_address);
        addressView.setText(places.getAddress());
        descView = findViewById(R.id.detail_desc);
        descView.setText(places.getDesc());


    }

    private void getData() {
        int resourceId, imageId;
        String[] titleName, itemName, address, tel, web, desc;

        // get titleNAme
        resourceId = getResources().getIdentifier("title_name_" + CATEGORY_ID, "array", getPackageName());
        titleName = getResources().getStringArray(resourceId);

        // get itemName
        resourceId = getResources().getIdentifier("item_name_" + CATEGORY_ID, "array", getPackageName());
        itemName = getResources().getStringArray(resourceId);

        // get address
        resourceId = getResources().getIdentifier("address_" + CATEGORY_ID, "array", getPackageName());
        address = getResources().getStringArray(resourceId);

        // get tel
        resourceId = getResources().getIdentifier("tel_" + CATEGORY_ID, "array", getPackageName());
        tel = getResources().getStringArray(resourceId);

        // get web
        resourceId = getResources().getIdentifier("web_" + CATEGORY_ID, "array", getPackageName());
        web = getResources().getStringArray(resourceId);

        // get desc
        resourceId = getResources().getIdentifier("desc_" + CATEGORY_ID, "array", getPackageName());
        desc = getResources().getStringArray(resourceId);

        // get image
        imageId = getResources().getIdentifier(CATEGORY_NAME + "_" + INDEX, "drawable", getPackageName());

        final ArrayList<Places> details = new ArrayList<>();
        for(int i=0 ; i<INDEX ; i++) {
            details.add(new Places(titleName[INDEX], itemName[INDEX], address[INDEX], tel[INDEX], web[INDEX], desc[INDEX], imageId));
        }

    }

}
