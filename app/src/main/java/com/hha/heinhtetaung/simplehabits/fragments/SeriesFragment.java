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

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.activities.DetailProgramActivity;
import com.hha.heinhtetaung.simplehabits.adapters.SeriesAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.event.LoadNetworkErrorEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.mvp.presenters.SeriesPresenter;
import com.hha.heinhtetaung.simplehabits.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/17/2018.
 */

public class SeriesFragment extends Fragment implements SeriesView {


    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter;
    private CurrentProgramDelegate mCurrentProgramDelegate;
    private CategoriesProgramDelegate mCategoriesProgramDelegate;
    private SeriesPresenter mSeriesPresenter;

    public SeriesFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);

        mSeriesPresenter = new SeriesPresenter(this);
        mSeriesPresenter.onCreate();
        mCurrentProgramDelegate = mSeriesPresenter;
        mCategoriesProgramDelegate = mSeriesPresenter;

        mSeriesAdapter = new SeriesAdapter(getContext(), mCurrentProgramDelegate, mCategoriesProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);


        return view;


    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mCurrentProgramDelegate = (CurrentProgramDelegate) context;
//        mCategoriesProgramDelegate = (CategoriesProgramDelegate) context;
//
//
//    }

    @Override
    public void onStart() {
        super.onStart();
        mSeriesPresenter.onStart();
//        EventBus.getDefault().register(this);

    }

    @Override
    public void onStop() {
        super.onStop();
        mSeriesPresenter.onStop();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void displaySeriesData(List<ShareParentVO> mShareParentVO) {
        mSeriesAdapter.appendNewData(mShareParentVO);
    }

    @Override
    public void launchDetailsCurrentProgram() {
        Intent intent = DetailProgramActivity.newIntentCurrent(getContext());
        startActivity(intent);
    }

    @Override
    public void launchDetailCategoriesProgram(String categoryId, String categoryItemId) {
        Intent intent = DetailProgramActivity.newIntentCategories(getContext(), categoryId, categoryItemId);
        startActivity(intent);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onDataLoaded(LoadReadyDataEvent event) {
//        mSeriesAdapter.setNewData(event.getShareParentVO());
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void networkError(LoadNetworkErrorEvent errorEvent) {
//        Snackbar.make(rvList.getRootView(), "Network Error!", Snackbar.LENGTH_INDEFINITE).show();
//    }


}