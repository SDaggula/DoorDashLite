package com.doordash.android.doordashlite;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.doordash.android.doordashlite.model.Restaurant;
import java.util.List;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class RestaurantListFragment extends Fragment {

    private RestaurantListAdapter mAdapter;
    private Context mContext;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_restaurant_main, container, false);
        init(rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void init(View view) {
        mProgressBar = view.findViewById(R.id.progressBar_cyclic);
        mProgressBar.setVisibility(View.VISIBLE);
        initRecyclerView(view);
        initViewModel();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.restaurant_recyclerview);
        mAdapter = new RestaurantListAdapter(mContext);

        //set Adapter
        recyclerView.setAdapter(mAdapter);

        //set itemClickListener
        mAdapter.setClickListener(itemClickListener);

        //Set layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);

        //set row divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initViewModel() {
        RestaurantListViewModel mRestaurantListViewModel = ViewModelProviders.of(this).get(RestaurantListViewModel.class);
        mRestaurantListViewModel.getRestaurantList().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(@Nullable final List<Restaurant> restaurants) {
                mProgressBar.setVisibility(View.GONE);
                mAdapter.setRestaurants(restaurants);
            }
        });
    }

    private RestaurantListAdapter.ItemClickListener itemClickListener = new RestaurantListAdapter.ItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Restaurant restaurant = mAdapter.getItem(position);
            Toast.makeText(mContext, "Clicked " + restaurant.getName(), Toast.LENGTH_SHORT).show();
        }
    };
}
