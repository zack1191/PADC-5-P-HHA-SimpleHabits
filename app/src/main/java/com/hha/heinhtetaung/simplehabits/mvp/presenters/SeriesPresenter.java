package com.hha.heinhtetaung.simplehabits.mvp.presenters;

import android.support.design.widget.Snackbar;

import com.hha.heinhtetaung.simplehabits.adapters.SeriesAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.event.LoadNetworkErrorEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.mvp.views.SeriesView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by E5 on 6/21/2018.
 */

public class SeriesPresenter extends BasePresenter<SeriesView> implements CategoriesProgramDelegate, CurrentProgramDelegate {

    private CategoriesProgramDelegate mCategoriesProgramDelegate;
    private CurrentProgramDelegate mCurrentProgramDelegate;

    public SeriesPresenter(SeriesView mView) {
        super(mView);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleModel.getsObjInstance().loadDatas();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(LoadReadyDataEvent event) {
        mView.displaySeriesData(event.getShareParentVO());
    }

    @Override
    public void onTapCategories(String categoryId, String categoryProgramId) {
        mView.launchDetailCategoriesProgram(categoryId, categoryProgramId);
    }

    @Override
    public void onTapStartHere() {
        mView.launchDetailsCurrentProgram();
    }
}
