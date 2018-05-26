package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.StartHereAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.event.LoadCurrentProgramEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadTopicEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/26/2018.
 */

public class StartHereViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_start_here)
    RecyclerView rvStartHere;

    private StartHereAdapter mStartHereAdapter;

    public StartHereViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        SimpleModel.getsObjInstance().loadData();
        EventBus.getDefault().register(this);


        mStartHereAdapter = new StartHereAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvStartHere.setLayoutManager(linearLayoutManager);
        rvStartHere.setAdapter(mStartHereAdapter);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadCurrentProgram(LoadCurrentProgramEvent event) {
        mStartHereAdapter.setCurrentProgram((List<CurrentProgramVO>) event.getCurrentProgram());
    }


}
