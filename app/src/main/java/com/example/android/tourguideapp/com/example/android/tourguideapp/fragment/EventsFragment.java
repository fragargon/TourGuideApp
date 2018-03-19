package com.example.android.tourguideapp.com.example.android.tourguideapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.com.example.android.tourguideapp.model.Tour;
import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.com.example.android.tourguideapp.adapter.ListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_pager, container, false);

        // Find the views and instantiate Id's
        String title = getResources().getString(R.string.events);
        String name = getResources().getString(R.string.name);

        /* create an arrayList of Tour*/
        final ArrayList<Tour> items = new ArrayList<>();
        for(int i=0; i<10; i++) {
            items.add(new Tour(title, name, R.drawable.cat1, R.drawable.ic_action_search));
        }

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list
        ListAdapter listAdapter = new ListAdapter(getActivity(), items);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_main xml layout file.
        ListView listView = rootView.findViewById(R.id.list_pager_main);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter(listAdapter);

        return rootView;
    }

}
