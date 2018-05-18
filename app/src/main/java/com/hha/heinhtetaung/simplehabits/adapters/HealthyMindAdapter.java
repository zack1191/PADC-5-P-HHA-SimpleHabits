package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.viewholders.HealthyMindViewHolders;

/**
 * Created by E5 on 5/18/2018.
 */

public class HealthyMindAdapter extends RecyclerView.Adapter<HealthyMindViewHolders> {
    @NonNull
    @Override
    public HealthyMindViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_healthy_mind, parent, false);
        return new HealthyMindViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthyMindViewHolders holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
