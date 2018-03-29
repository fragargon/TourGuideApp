package com.example.android.tourguideapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideapp.PagerActivity;
import com.example.android.tourguideapp.fragment.BarFragment;
import com.example.android.tourguideapp.fragment.EventsFragment;
import com.example.android.tourguideapp.fragment.FoodFragment;
import com.example.android.tourguideapp.fragment.HotelFragment;
import com.example.android.tourguideapp.fragment.InfoFragment;
import com.example.android.tourguideapp.model.Places;
import com.example.android.tourguideapp.fragment.PlacesFragment;
import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.fragment.TabFragment;

/**
 * {@link PagerAdapter} is a {@link FragmentPagerAdapter}
 * that provides the layout for each list based on a data source
 * which is of {@link Places}
 */

public class PagerAdapter extends FragmentPagerAdapter {

    /** Declare variable to handle the item's position */
    private final int PAGES = 6;
    private String tabTitles[] = new String[PAGES];

    /**
     * Create a new {@link PagerAdapter} object
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each
     *           fragment's state in the adapter across swipe.
     */
    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        tabTitles[0] = context.getString(R.string.info);
        tabTitles[1] = context.getString(R.string.hotels);
        tabTitles[2] = context.getString(R.string.food);
        tabTitles[3] = context.getString(R.string.bar);
        tabTitles[4] = context.getString(R.string.events);
        tabTitles[5] = context.getString(R.string.places);
    }

    /**
     * Return the total pages of the {@link PagerActivity}.
     */
    @Override
    public int getCount() {
        return PAGES;
    }

    /**
     * Return {@link Fragment} that should be for the given page number.
     * It is display in {@link PagerActivity}
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new HotelFragment();
            case 2:
                return new FoodFragment();
            case 3:
                return new BarFragment();
            case 4:
                return new EventsFragment();
            case 5:
                return new PlacesFragment();
            default:
                return new InfoFragment();
        }
    }

    /**
     * Return {@link TabFragment} that should be for the given page number.
     * It is display in {@link PagerActivity}
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
