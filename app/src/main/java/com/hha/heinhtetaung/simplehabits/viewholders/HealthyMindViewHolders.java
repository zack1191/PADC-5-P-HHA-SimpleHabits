package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.HealthyMindAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.event.LoadCategoriesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/18/2018.
 */

public class HealthyMindViewHolders extends RecyclerView.ViewHolder {

    @BindView(R.id.rv_healty)
    RecyclerView rvHealthy;

    private HealthyMindAdapter mHealthyMindAdapter;

    public HealthyMindViewHolders(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        SimpleModel.getsObjInstance().loadData();
        EventBus.getDefault().register(this);

        mHealthyMindAdapter = new HealthyMindAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHealthy.setLayoutManager(linearLayoutManager);
        rvHealthy.setAdapter(mHealthyMindAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCategoriesLoaded(LoadCategoriesEvent event) {
        mHealthyMindAdapter.setCategoriesProgram(event.getCategoriesProgram());
    }

}
