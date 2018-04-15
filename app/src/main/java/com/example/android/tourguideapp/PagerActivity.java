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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tourguideapp.adapter.PagerAdapter;
import com.example.android.tourguideapp.fragment.TabFragment;

import static com.example.android.tourguideapp.model.Config.TAB_SELECT;

/**
 * Create an {@link PagerAdapter} activity which shows
 * a view pager with an {@link TabFragment} tab layout.
 */

public class PagerActivity extends AppCompatActivity {

    private static int tabSelect = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set the content of the activity to use the category_main.xml layout file. */
        setContentView(R.layout.category_main);

        /* Get Intent Extra */
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            tabSelect = bundle.getInt(TAB_SELECT);
        }

        /* Find the view pager that will allow the user to swipe between fragments. */
        ViewPager vp = findViewById(R.id.viewpager);
        /* Create an adapter that knows which fragment should be shown on each page. */
        PagerAdapter adapter = new PagerAdapter(this, getSupportFragmentManager());

        /* Set the adapter onto the view pager. */
        vp.setAdapter(adapter);
        vp.setCurrentItem(tabSelect);

        /* Find the tab layout that shows the tabs. */
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vp);
    }
}
