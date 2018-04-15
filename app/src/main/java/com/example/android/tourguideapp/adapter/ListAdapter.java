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

package com.example.android.tourguideapp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

/**
 * {@link ListAdapter} is an {@link ArrayAdapter} that provides
 * the layout for each list based on data source {@link Places} object.
 */


public class ListAdapter extends ArrayAdapter<Places>{

    /**
     * This is a custom constructor.
     * The context is used to inflate the layout file.
     * The list is the data we want to populate into the list
     * @param context The current context. Used to inflate the layout.
     * @param listPager A list of Places object to display in a list
     */

    public ListAdapter(Activity context, ArrayList<Places> listPager) {
        super(context, 0, listPager);
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
        View listViewPager = convertView;
        if(listViewPager == null) {
            listViewPager = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /* Get {@link Places} object located at this position in the list */
        Places currentList = getItem(position);

        /* Find the TextView, get and set the text from the current titleName object */
        TextView titleName = listViewPager.findViewById(R.id.list_title_name);
        if (currentList != null) {
            titleName.setText(currentList.getTitleName());
        }

        /* Find the TextView, get and set the text from the current itemName object */
        TextView itemName = listViewPager.findViewById(R.id.list_item_name);
        if (currentList != null) {
            itemName.setText(currentList.getItemName());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawablePicId = listViewPager.findViewById(R.id.list_image_view);
        if (currentList != null) {
            drawablePicId.setImageResource(currentList.getPhotoId());
        }

        /* Find the ImageView, get and set the image from the current drawable object */
        ImageView drawableIconId = listViewPager.findViewById(R.id.list_icon_view);
        if (currentList != null) {
            drawableIconId.setImageResource(currentList.getIconId());
        }

        /* Return the whole list item layout */
        return listViewPager;
    }
}
