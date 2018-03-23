package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tourguideapp.adapter.PagerAdapter;
import com.example.android.tourguideapp.fragment.TabFragment;

/**
 * Create an {@link PagerAdapter} activity which shows
 * a view pager with an {@link TabFragment} tab layout.
 */

public class PagerActivity extends AppCompatActivity {

    private static int NUM_CAT = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set the content of the activity to use the category_main.xml layout file. */
        setContentView(R.layout.category_main);

        /* Get Intent Extra */
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            NUM_CAT = bundle.getInt("category");
        }

        /* Find the view pager that will allow the user to swipe between fragments. */
        ViewPager vp = findViewById(R.id.viewpager);
        /* Create an adapter that knows which fragment should be shown on each page. */
        PagerAdapter adapter = new PagerAdapter(this, getSupportFragmentManager());

        /* Set the adapter onto the view pager. */
        vp.setAdapter(adapter);
        vp.setCurrentItem(NUM_CAT);

        /* Find the tab layout that shows the tabs. */
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vp);
    }
}
