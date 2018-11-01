package com.doordash.android.doordashlite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doordash.android.doordashlite.model.Restaurant;

import java.util.Collections;
import java.util.List;

/**
 * Created by SreeL1 on 10/30/2018.
 *
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView restaurantThumbView;
        private final TextView restaurantNameView;
        private final TextView restaurantDescView;
        private final TextView restaurantStatusView;

        private RestaurantViewHolder(View itemView) {
            super(itemView);
            restaurantThumbView = itemView.findViewById(R.id.restaurant_thumbnail);
            restaurantNameView = itemView.findViewById(R.id.restaurant_name);
            restaurantDescView = itemView.findViewById(R.id.restaurant_description);
            restaurantStatusView = itemView.findViewById(R.id.restaurant_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    private List<Restaurant> mRestaurants = Collections.emptyList();
    private Context mContext;
    private ItemClickListener mItemClickListener;

    RestaurantListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.restaurant_row_layout, parent, false);
        return new RestaurantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {
        Restaurant current = mRestaurants.get(position);
        Glide.with(mContext)
                .load(current.getCoverImgUrl())
                .into(holder.restaurantThumbView);
        holder.restaurantNameView.setText(current.getName());
        holder.restaurantDescView.setText(current.getDescription());
        holder.restaurantStatusView.setText(current.getStatus());
    }

    void setRestaurants(List<Restaurant> restaurants) {
        mRestaurants = restaurants;
        notifyDataSetChanged();
    }

    Restaurant getItem(int position) {
        if (mRestaurants == null)
            return null;
        return mRestaurants.get(position);
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


