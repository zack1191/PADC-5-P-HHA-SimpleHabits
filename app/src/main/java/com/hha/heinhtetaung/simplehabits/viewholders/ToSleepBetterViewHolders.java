package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.ToSleepBetterAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/18/2018.
 */

public class ToSleepBetterViewHolders extends ViewHolder {
    @BindView(R.id.rv_tosleep)
    RecyclerView rvToSleep;

    private ToSleepBetterAdapter mtToSleepBetterAdapter;

    public ToSleepBetterViewHolders(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mtToSleepBetterAdapter = new ToSleepBetterAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvToSleep.setLayoutManager(linearLayoutManager);
        rvToSleep.setAdapter(mtToSleepBetterAdapter);
    }
}
