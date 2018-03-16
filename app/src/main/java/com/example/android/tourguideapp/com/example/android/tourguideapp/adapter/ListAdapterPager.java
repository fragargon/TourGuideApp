package com.example.android.tourguideapp.com.example.android.tourguideapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.com.example.android.tourguideapp.model.ItemListModel;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

/**
 * {@link GridAdapter} is an {@link ArrayAdapter} that provides
 * the layout for each list based on data source {@link ItemListModel} object.
 */


public class ListAdapterPager extends ArrayAdapter<ItemListModel>{

    /* Initialize global variable */
    private Context myContext;

    /**This is a custom constructor.
     * The context is used to inflate the layout file.
     * The list is the data we want to populate into the list
     * @param context The current context. Used to inflate the layout.
     * @param itemListPager A list of ItemListModel object to display in a list
     */

    public ListAdapterPager(Activity context, ArrayList<ItemListModel> itemListPager) {
        super(context, 0, itemListPager);
        myContext = context;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView)
     * @param position The position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent Te parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, @Nullable ViewGroup parent) {
        /* Check if the existing view is being reused, otherwise inflate the view */
        View itemListViewPager = convertView;
        if(itemListViewPager == null) {
            itemListViewPager = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_pager, parent, false);
        }

        /* Get {@link ItemListModel} object located at this position in the list */
        ItemListModel currentList = getItem(position);

        /* Find the TextView, get and set the text from the current titleName object */
        TextView titleName = itemListViewPager.findViewById(R.id.thumbnail_title);
        if (currentList != null) {
            titleName.setText(currentList.getTitleName());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawablePicId = itemListViewPager.findViewById(R.id.thumbnail_image);
        if (currentList != null) {
            drawablePicId.setImageResource(currentList.getDrawablePic());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawableIconId = itemListViewPager.findViewById(R.id.thumbnail_icon);
        if (currentList != null) {
            drawableIconId.setImageResource(currentList.getDrawableIcon());
        }

        /* Return the whole list item layout */
        return itemListViewPager;
    }
}
