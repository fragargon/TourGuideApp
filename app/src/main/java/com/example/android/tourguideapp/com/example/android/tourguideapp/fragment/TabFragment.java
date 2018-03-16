package com.example.android.tourguideapp.com.example.android.tourguideapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tourguideapp.R;

/**
 * Provides the appropriate {@link TabFragment} for a view pager.
 */
public class TabFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int myPage;


    public static TabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TabFragment fragment = new TabFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPage = getArguments().getInt(ARG_PAGE);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab, container,false);
        TextView tv = (TextView) v;
        tv.setText("Fragment #" + myPage);
        return v;
    }

}
