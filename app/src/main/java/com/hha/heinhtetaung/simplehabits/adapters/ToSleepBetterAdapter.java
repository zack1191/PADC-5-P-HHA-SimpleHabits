package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemToSleepBetterViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ToSleepBetterViewHolders;

/**
 * Created by E5 on 5/18/2018.
 */

public class ToSleepBetterAdapter extends RecyclerView.Adapter<ItemToSleepBetterViewHolder> {
    @NonNull
    @Override
    public ItemToSleepBetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_to_sleep_better, parent, false);
        return new ItemToSleepBetterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemToSleepBetterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
