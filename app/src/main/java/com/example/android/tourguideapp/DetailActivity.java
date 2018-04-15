/*
 * PROJECT LICENSE
 *
 * This project was submitted by fragargon as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code
 * and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if
 * you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018. fragargon
 *
 * Besides the above notice, the following license applies and this license notice
 * must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.model.Places;

import static com.example.android.tourguideapp.model.Config.CATEGORY_ID;

public class DetailActivity extends AppCompatActivity {

    /* declare UI */
    ImageView imageView;
    TextView titleNameView, itemNameView, telView, addressView, descView;
    Button webView;

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
        final String titleName = chosenItem.getTitleName();
        final String itemName = chosenItem.getItemName();
        final String address = chosenItem.getAddress();
        final String tel = chosenItem.getTel();
        final String web = chosenItem.getWeb();
        final String desc = chosenItem.getDesc();
        final int image = chosenItem.getPhotoId();

        /* Initialize UI */
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

        descView = findViewById(R.id.detail_desc);
        descView.setText(desc);

        imageView = findViewById(R.id.detail_image);
        imageView.setImageResource(image);

        /* Set an oncLick listener on the view*/
        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickWebUrl(web);
            }
        });

        /* Set an oncLick listener on the view*/
        telView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDialPhoneNumber(tel);
            }
        });

        /* Set an oncLick listener on the view*/
        addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickShowMap("geo:0,0?q=" + address);
            }
        });

    }

    /* This method send the web url from onclick */
    public void onClickWebUrl(String openUrl) {
        Uri webPage = Uri.parse(openUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW,webPage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* This method dial the number tel from onClick */
    public void onClickDialPhoneNumber (String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* This method get the location address*/
    public void onClickShowMap (String getLocation) {
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(getLocation));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
