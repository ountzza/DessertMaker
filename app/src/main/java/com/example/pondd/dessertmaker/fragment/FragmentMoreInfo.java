package com.example.pondd.dessertmaker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pondd.dessertmaker.R;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentMoreInfo extends Fragment {

    private ViewPager viewPager;
    private int dessertPosition;

    public FragmentMoreInfo() {
        super();
    }

    public static FragmentMoreInfo newInstance(int position) {
        FragmentMoreInfo fragment = new FragmentMoreInfo();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_info, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
//        setRetainInstance(true);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return FragmentMoreInfoMain.newInstance(dessertPosition);
                    case 1:
                        return FragmentMoreInfoIngrediants.newInstance(dessertPosition);
                    case 2:
                        return FragmentMoreInfoDirections.newInstance(dessertPosition);
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        if (getArguments() != null) {
            dessertPosition = getArguments().getInt("position");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
