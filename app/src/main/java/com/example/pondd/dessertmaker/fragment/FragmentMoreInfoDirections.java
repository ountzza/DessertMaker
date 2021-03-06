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
public class FragmentMoreInfoDirections extends Fragment {

    public FragmentMoreInfoDirections() {
        super();
    }

    public static FragmentMoreInfoDirections newInstance(int dessertPosition) {
        FragmentMoreInfoDirections fragment = new FragmentMoreInfoDirections();
        Bundle args = new Bundle();
        args.putInt("dessertPosition", dessertPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_more_info_directions, container, false);
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
