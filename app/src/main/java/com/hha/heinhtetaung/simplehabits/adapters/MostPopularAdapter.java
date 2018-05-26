package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemMostPopularViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.MostPopularViewHolder;

/**
 * Created by E5 on 5/18/2018.
 */

public class MostPopularAdapter extends RecyclerView.Adapter<ItemMostPopularViewHolder> {
    @NonNull
    @Override
    public ItemMostPopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_most_popular, parent, false);
        return new ItemMostPopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMostPopularViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 8;
    }
}
