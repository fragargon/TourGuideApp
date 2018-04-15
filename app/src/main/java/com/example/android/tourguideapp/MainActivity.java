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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.tourguideapp.adapter.GridAdapter;
import com.example.android.tourguideapp.model.Helper;

import static com.example.android.tourguideapp.model.Config.TAB_SELECT;

public class MainActivity extends AppCompatActivity {

    /* Declare global variable */
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Create {@link Places} a gridView
        the data source is a list of object from the ArrayList.
        */
        GridAdapter adapter = new GridAdapter(this, Helper.getCategory(getApplicationContext()));
        gridView = findViewById(R.id.grid_container);
        gridView.setAdapter(adapter);

        /* Create an intent to handle onItemClick position and send it to PagerActivity */
        final Intent intent = new Intent(MainActivity.this, PagerActivity.class);

        /* Bind the abstract method to the gridView and gives parameters to its interface */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.putExtra(TAB_SELECT,0); // InfoFragment
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra(TAB_SELECT,1); // HotelFragment
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra(TAB_SELECT, 2); // FoodFragment
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra(TAB_SELECT, 3); // BarFragment
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra(TAB_SELECT, 4); // EventsFragment
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra(TAB_SELECT, 5); // PlacesFragment
                        startActivity(intent);
                        break;
                        default:
                            intent.putExtra(TAB_SELECT, 0); // InfoFragment
                            startActivity(intent);
                            break;
                }
            }
        });

    }
}
