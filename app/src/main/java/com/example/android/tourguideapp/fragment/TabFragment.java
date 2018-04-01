package com.example.android.tourguideapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tourguideapp.R;

import static com.example.android.tourguideapp.model.Config.ARG_PAGE;

/**
 * Provides the appropriate {@link TabFragment} for a view pager.
 */
public class TabFragment extends Fragment {

    static TabFragment fragment;
    private int myPage;


    public static TabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        fragment = new TabFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPage = getArguments().getInt(ARG_PAGE);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab, container,false);
        TextView tv = (TextView) v;
        tv.setText("Fragment #" + myPage);
        return v;
    }

}
