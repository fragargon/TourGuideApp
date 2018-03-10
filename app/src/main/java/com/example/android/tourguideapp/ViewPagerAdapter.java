package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link ViewPagerAdapter} is a {@link FragmentPagerAdapter}
 * that provides the layout for each list based on a data source
 * which is of {@link ItemListModel}
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context myContext;

    /** Declare variable to handle the item's position */
    private final int PAGES = 4;
    private String tabTitles[] = new String[PAGES];

    /**
     * Create a new {@link ViewPagerAdapter} object
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each
     *           fragment's state in the adapter across swipe.
     */
    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        myContext = context;
        tabTitles[0] = context.getString(R.string.hotels);
        tabTitles[1] = context.getString(R.string.events);
        tabTitles[2] = context.getString(R.string.drink);
        tabTitles[3] = context.getString(R.string.info);
    }

    /**
     * Return the total pages of the {@link ViewPagerActivity}.
     */
    @Override
    public int getCount() {
        return PAGES;
    }

    /**
     * Return {@link Fragment} that should be for the given page number.
     * It is display in {@link ViewPagerActivity}
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HotelFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new DrinkFragment();
            case 3:
                return new InfoFragment();
            default:
                return new HotelFragment();
        }
    }

    /**
     * Return {@link TabFragment} that should be for the given page number.
     * It is display in {@link ViewPagerActivity}
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
