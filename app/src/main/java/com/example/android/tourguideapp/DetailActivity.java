package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.model.Places;

import static com.example.android.tourguideapp.model.Config.CATEGORY_ID;

public class DetailActivity extends AppCompatActivity {

    /* declare UI */
    ImageView imageView;
    TextView titleNameView, itemNameView, webView, telView, addressView, descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /* get intent */
        Intent intent = getIntent();
        Places chosenItem = intent.getParcelableExtra(CATEGORY_ID);

        /* get the logs from intent chosenItem */
        Log.v("my_tag", "places object received is:" + chosenItem.toString());

        /* set variables */
        String titleName = chosenItem.getTitleName();
        String itemName = chosenItem.getItemName();
        String address = chosenItem.getAddress();
        String tel = chosenItem.getTel();
        String web = chosenItem.getWeb();
        String desc = chosenItem.getDesc();
        int image = chosenItem.getPhotoId();

        /* Initialize de views */
        titleNameView = findViewById(R.id.detail_title_name);
        titleNameView.setText(titleName);
        itemNameView = findViewById(R.id.detail_item_name);
        itemNameView.setText(itemName);
        addressView = findViewById(R.id.detail_address);
        addressView.setText(address);
        telView = findViewById(R.id.detail_tel);
        if (chosenItem.hasTel()){
            telView.setText(tel);
            telView.setVisibility(View.VISIBLE);
        }else {
            telView.setVisibility(View.GONE);
        }

        webView = findViewById(R.id.detail_web);
        webView.setText(web);
        descView = findViewById(R.id.detail_desc);
        descView.setText(desc);
        imageView = findViewById(R.id.detail_image);
        imageView.setImageResource(image);


    }

}
