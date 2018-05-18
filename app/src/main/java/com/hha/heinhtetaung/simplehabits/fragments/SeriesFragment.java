package com.hha.heinhtetaung.simplehabits.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.AllTopicAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.HealthyMindAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.MostPopularAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.ToSleepBetterAdapter;
import com.hha.heinhtetaung.simplehabits.viewholders.AllTopicViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemToSleepBetterViewHolders;
import com.hha.heinhtetaung.simplehabits.viewholders.MostPopularViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/17/2018.
 */

public class SeriesFragment extends Fragment {
    private HealthyMindAdapter healthyMindAdapter;

    @BindView(R.id.rv_healty)
    RecyclerView rvHealthy;

    @BindView(R.id.rv_tosleep)
    RecyclerView rvToSleep;

    @BindView(R.id.rv_most_popular)
    RecyclerView rvMostPopular;

    @BindView(R.id.rv_all_topic)
    RecyclerView rvAllTopic;

    private ItemToSleepBetterViewHolders itemToSleepBetterViewHolders;
    private MostPopularViewHolder mostPopularViewHolder;
    private AllTopicViewHolder allTopicViewHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        HealthyMindAdapter healthyMindAdapter = new HealthyMindAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHealthy.setAdapter(healthyMindAdapter);
        rvHealthy.setLayoutManager(linearLayoutManager);

        ToSleepBetterAdapter toSleepBetterAdapter = new ToSleepBetterAdapter();
        LinearLayoutManager lmToSleep = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvToSleep.setAdapter(toSleepBetterAdapter);
        rvToSleep.setLayoutManager(lmToSleep);

        MostPopularAdapter mostPopularAdapter = new MostPopularAdapter();
        LinearLayoutManager lmMostPopular = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMostPopular.setLayoutManager(lmMostPopular);
        rvMostPopular.setAdapter(mostPopularAdapter);

        AllTopicAdapter allTopicAdapter = new AllTopicAdapter();
        LinearLayoutManager lmAllTopic = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvAllTopic.setLayoutManager(lmAllTopic);
        rvAllTopic.setAdapter(allTopicAdapter);

        return view;


    }
}
