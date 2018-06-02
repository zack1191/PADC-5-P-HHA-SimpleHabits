package com.hha.heinhtetaung.simplehabits.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.Activities.StartHereActivity;
import com.hha.heinhtetaung.simplehabits.MainActivity;
import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.SimpleHabitApp;
import com.hha.heinhtetaung.simplehabits.adapters.SeriesAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.event.LoadNetworkErrorEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;

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

    private SeriesAdapter mSeriesAdapter;
    private CurrentProgramDelegate mCurrentProgramDelegate;
    private CategoriesProgramDelegate mCategoriesProgramDelegate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);


        mSeriesAdapter = new SeriesAdapter(getContext(), mCurrentProgramDelegate, mCategoriesProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);
        SimpleModel.getsObjInstance().loadDatas();

        return view;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCurrentProgramDelegate = (CurrentProgramDelegate) context;
        mCategoriesProgramDelegate = (CategoriesProgramDelegate) context;


    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(LoadReadyDataEvent event) {
        mSeriesAdapter.setNewData(event.getShareParentVO());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void networkError(LoadNetworkErrorEvent errorEvent) {
        Snackbar.make(rvList.getRootView(), "Network Error!", Snackbar.LENGTH_INDEFINITE).show();
    }


}