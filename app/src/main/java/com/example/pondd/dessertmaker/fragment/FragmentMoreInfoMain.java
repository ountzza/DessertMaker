package com.example.pondd.dessertmaker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pondd.dessertmaker.R;
import com.example.pondd.dessertmaker.dao.DessertItemDao;
import com.example.pondd.dessertmaker.manager.DessertItemManager;
import com.inthecheesefactory.thecheeselibrary.manager.ImageLoaderManager;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentMoreInfoMain extends Fragment {

    int dessertPosition;
    TextView txtName;
    TextView textDescrition;
    ImageView ivImage;

    public FragmentMoreInfoMain() {
        super();
    }

    public static FragmentMoreInfoMain newInstance(int dessertPosition) {
        FragmentMoreInfoMain fragment = new FragmentMoreInfoMain();
        Bundle args = new Bundle();
        args.putInt("dessertPosition", dessertPosition);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_info_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        //setRetainInstance(true);
        dessertPosition = getArguments().getInt("dessertPosition");

        txtName = (TextView)rootView.findViewById(R.id.topText);
        textDescrition = (TextView)rootView.findViewById(R.id.bottomText);
        ivImage = (ImageView)rootView.findViewById(R.id.imageViewShow);

        DessertItemDao dao = (DessertItemDao) DessertItemManager.getInstance().getData().getData()[dessertPosition];
        txtName.setText(dao.getName());
        textDescrition.setText(dao.getDescription());
        ImageLoaderManager.getInstance().load(dao.getImageUrl(),ivImage);
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
