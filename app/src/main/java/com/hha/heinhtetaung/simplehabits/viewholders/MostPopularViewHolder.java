package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.MostPopularAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/18/2018.
 */

public class MostPopularViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rv_most_popular)
    RecyclerView rvMostPopular;

    private MostPopularAdapter mostPopularAdapter;

    public MostPopularViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mostPopularAdapter=new MostPopularAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMostPopular.setLayoutManager(linearLayoutManager);
        rvMostPopular.setAdapter(mostPopularAdapter);
    }
}
