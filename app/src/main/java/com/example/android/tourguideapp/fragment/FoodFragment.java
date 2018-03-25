package com.example.android.tourguideapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguideapp.DetailActivity;
import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.adapter.ListAdapter;
import com.example.android.tourguideapp.model.Places;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {
    private final int CATEGORY_ID = 2;
    private final String CATEGORY_NAME = "food";

    public FoodFragment() {
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
        int INDEX = 10;

        // Find the  Id's and create an array
        String [] titleName = getResources().getStringArray(R.array.item_name_2);
        String [] foodName = getResources().getStringArray(R.array.title_name_2);

        /* create an arrayList of Places*/
        final ArrayList<Places> items = new ArrayList<>();
        for(int i=0; i<INDEX; i++) {
            // get the categories drawables
            int drawableId = getResources().getIdentifier("food_" + (i+1), "drawable", getActivity().getPackageName());
            items.add(new Places(titleName[i], foodName[i], drawableId, R.drawable.ic_action_search));
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

        // Set an listener on each item in the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("categoryId", CATEGORY_ID);
                i.putExtra("categoryName", CATEGORY_NAME);
                i.putExtra("index", position);
                startActivity(i);
            }
        });

        return rootView;
    }

}