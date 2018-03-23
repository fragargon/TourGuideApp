package com.example.android.tourguideapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.adapter.ListAdapter;
import com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {
    private final int INDEX = 8;

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_pager, container, false);

        // Find the  Id's and create an array
        String[] titleName = getResources().getStringArray(R.array.item_name_5);
        String[] placesName = getResources().getStringArray(R.array.title_name_5);

        /* create an arrayList of Places*/
        final ArrayList<Places> items = new ArrayList<>();
        for (int i = 0; i < INDEX; i++) {
            // get the categories drawables
            int drawableId = getResources().getIdentifier("places_" + (i + 1), "drawable", getActivity().getPackageName());
            items.add(new Places(titleName[i], placesName[i], drawableId, R.drawable.ic_action_search));
        }

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list
        ListAdapter listAdapter = new ListAdapter(getActivity(), items);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_main xml layout file.
        ListView listView = rootView.findViewById(R.id.view_pager_activity);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter(listAdapter);

        return rootView;
    }

}