package com.hha.heinhtetaung.simplehabits.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.Activities.StartHereActivity;
import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.SeriesAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.SimpleHabitsDelegate;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/17/2018.
 */

public class SeriesFragment extends Fragment implements SimpleHabitsDelegate {


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);

        EventBus.getDefault().register(this);
        mSeriesAdapter = new SeriesAdapter(getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);

        SimpleModel.getsObjInstance().loadDatas();

        return view;


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(LoadReadyDataEvent event) {
        mSeriesAdapter.setNewData(event.getShareParentVO());
    }


    @Override
    public void onTapStartHere(CurrentProgramVO tappedCurrent) {

        Intent intent = new Intent(getContext(), StartHereActivity.class);
        intent.putExtra("programId", tappedCurrent.getProgramId());
        startActivity(intent);

    }

    @Override
    public void onTapTopic() {
        Toast.makeText(getContext(), "Tap all topics", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTapCategories() {
//        Intent intent = new Intent(getContext(), StartHereActivity.class);
//        startActivity(intent);
//        Toast.makeText(getContext(), "Tap Categories", Toast.LENGTH_SHORT).show();
    }


}