package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.AllTopicAdapter;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.event.LoadTopicEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/18/2018.
 */

public class AllTopicViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rv_all_topic)
    RecyclerView rvAllTopic;

    AllTopicAdapter mAllTopicAdapter;


    public AllTopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        SimpleModel.getsObjInstance().loadData();
        EventBus.getDefault().register(this);

        mAllTopicAdapter = new AllTopicAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
        rvAllTopic.setLayoutManager(linearLayoutManager);
        rvAllTopic.setAdapter(mAllTopicAdapter);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadTopic(LoadTopicEvent event) {
        mAllTopicAdapter.setTopics(event.getTopics());
    }


}
