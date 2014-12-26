package com.example.pondd.dessertmaker.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pondd.dessertmaker.R;
import com.example.pondd.dessertmaker.adapter.DessertListAdapter;
import com.example.pondd.dessertmaker.dao.DessertItemCollectionDao;
import com.example.pondd.dessertmaker.manager.DessertItemManager;
import com.example.pondd.dessertmaker.manager.http.HTTPEngine;
import com.example.pondd.dessertmaker.manager.http.HTTPEngineListener;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class FragmentMain extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private DessertListAdapter mDessertListAdapter;

    public FragmentMain() {
        super();
    }

    public static FragmentMain newInstance() {
        FragmentMain fragment = new FragmentMain();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // init instance with rootView.findViewById here
        setRetainInstance(true);
        listView = (ListView) rootView.findViewById(R.id.ListView);
        listView.setAdapter(mDessertListAdapter = new DessertListAdapter());

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
            }
        });
        loadData();
    }

    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);
        HTTPEngine.getInstance().loadDessertList(new HTTPEngineListener<DessertItemCollectionDao>() {
            @Override
            public void onResponse(DessertItemCollectionDao data, String rawData) {
                if (data.isSuccess()) {
                    //Loaded and no error
                    //Toast.makeText(getActivity(),data.getData()[0].getName(),Toast.LENGTH_SHORT).show();
                    DessertItemManager.getInstance().setData(data);
                    mDessertListAdapter.notifyDataSetChanged();
                } else {
                    //Loaded and not work

                }
                swipeRefreshLayout.setRefreshing(false);
            }


            @Override
            public void onFailure(DessertItemCollectionDao data, String rawData) {
                // Not loaded
                swipeRefreshLayout.setRefreshing(false);
            }
        });
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
