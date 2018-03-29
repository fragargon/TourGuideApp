package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Places places;

    private int CATEGORY_ID = 1;
    private String CATEGORY_NAME = "";
    private int INDEX = 0;
    private final ArrayList details = new ArrayList();

    ImageView imageView;
    TextView titleNameView, itemNameView, webView, telView, addressView, descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get intent
        CATEGORY_ID = getIntent().getExtras().getInt("categoryId");
        Log.v("getExtra", "categoryId received:" + CATEGORY_ID);
        CATEGORY_NAME = getIntent().getExtras().getString("categoryName");
        Log.v("getExtra", "categoryName received:" + CATEGORY_NAME);
        INDEX = getIntent().getExtras().getInt("index");
        Log.v("getExtra", "index received:" + INDEX);

        // set data
        getData();

        //titleNameView = findViewById(R.id.detail_title_name);
        //titleNameView.setText(INDEX);
        //imageView = findViewById(R.id.detail_image);
        //imageView.setImageResource(INDEX);
        //itemNameView = findViewById(R.id.detail_item_name);
        //itemNameView.setText(INDEX);
        //webView = findViewById(R.id.detail_web);
        //webView.setText(places.getWeb());
        //telView = findViewById(R.id.detail_tel);
        //telView.setText(places.getTel());
        //addressView = findViewById(R.id.detail_address);
        // addressView.setText(places.getAddress());
        //descView = findViewById(R.id.detail_desc);
        //descView.setText(places.getDesc());


    }

    private void getData() {

    }

}
