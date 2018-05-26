package com.hha.heinhtetaung.simplehabits.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.SimpleHabitApp;
import com.hha.heinhtetaung.simplehabits.adapters.AllTopicAdapter;
import com.hha.heinhtetaung.simplehabits.adapters.SeriesAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;

import com.hha.heinhtetaung.simplehabits.event.LoadTopicEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/17/2018.
 */

public class SeriesFragment extends Fragment {


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter = new SeriesAdapter();
    private AllTopicAdapter mAllTopicAdapter = new AllTopicAdapter();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);

        mSeriesAdapter = new SeriesAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);


        return view;


    }


//
//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onLoadedTopics(LoadTopicEvent event) {
//        Log.d(SimpleHabitApp.LOG_TAG, "onLoadedTopics" + event.getTopics().size());
//
//        mAllTopicAdapter.setTopics(event.getTopics());
//
//    }


}
