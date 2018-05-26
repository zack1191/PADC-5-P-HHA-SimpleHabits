package com.hha.heinhtetaung.simplehabits.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;

import com.hha.heinhtetaung.simplehabits.viewholders.AllTopicViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.HealthyMindViewHolders;
import com.hha.heinhtetaung.simplehabits.viewholders.StartHereViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ToSleepBetterViewHolders;
import com.hha.heinhtetaung.simplehabits.viewholders.MostPopularViewHolder;

/**
 * Created by E5 on 5/22/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter {


    public SeriesAdapter() {

    }

    private static final int START_HERE = 0;
    private static final int HEALTHY_MIND = 1;
    private static final int TO_SLEEP_BETTER = 2;
    private static final int MOST_POPULAR = 3;
    private static final int ALL_TOPICS = 4;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case START_HERE:
                viewHolder = new StartHereViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_start_here, parent, false));
                break;
            case HEALTHY_MIND:
                viewHolder = new HealthyMindViewHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_healthy_mind, parent, false));

                break;
            case TO_SLEEP_BETTER:
                viewHolder = new ToSleepBetterViewHolders(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_to_sleep_better, parent, false));
                break;
            case MOST_POPULAR:
                viewHolder = new MostPopularViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_most_popular, parent, false));
                break;
            case ALL_TOPICS:
                viewHolder = new AllTopicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_topics, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (position) {
            case 0:
                i = START_HERE;
                break;
            case 1:
                i = HEALTHY_MIND;
                break;
            case 2:
                i = TO_SLEEP_BETTER;
                break;
            case 3:
                i = MOST_POPULAR;
                break;
            case 4:
                i = ALL_TOPICS;
                break;
        }
        return i;
    }

    @Override
    public int getItemCount() {
        return 5;
    }


}
