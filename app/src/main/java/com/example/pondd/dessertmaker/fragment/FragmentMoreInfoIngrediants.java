package com.example.pondd.dessertmaker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pondd.dessertmaker.R;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentMoreInfoIngrediants extends Fragment {

    public FragmentMoreInfoIngrediants() {
        super();
    }

    public static FragmentMoreInfoIngrediants newInstance(int dessertPosition) {
        FragmentMoreInfoIngrediants fragment = new FragmentMoreInfoIngrediants();
        Bundle args = new Bundle();
        args.putInt("dessertPosition", dessertPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_info_ingredients, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
       // setRetainInstance(true);
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
