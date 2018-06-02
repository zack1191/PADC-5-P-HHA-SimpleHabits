package com.hha.heinhtetaung.simplehabits.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hha.heinhtetaung.simplehabits.Activities.StartHereActivity;
import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.CategoriesProgramAdapter;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.SimpleHabitsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 5/18/2018.
 */

public class CategoriesProgramViewHolder extends BaseViewHolder<CategoriesProgramVO> implements SimpleHabitsDelegate {

    @BindView(R.id.rv_healty)
    RecyclerView rvHealthy;

    @BindView(R.id.tv_healty)
    TextView tvTitleHealthy;

    private CategoriesProgramAdapter mCategoriesProgramAdapter;


    public CategoriesProgramViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);


        mCategoriesProgramAdapter = new CategoriesProgramAdapter(itemView.getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHealthy.setLayoutManager(linearLayoutManager);
        rvHealthy.setAdapter(mCategoriesProgramAdapter);
    }

    @Override
    public void setData(CategoriesProgramVO data) {
        tvTitleHealthy.setText(data.getTitle());
        mCategoriesProgramAdapter.setNewData(data.getPrograms());
    }

    @Override
    public void onTapStartHere(CurrentProgramVO tappedCurrent) {

    }

    @Override
    public void onTapTopic() {

    }

    @Override
    public void onTapCategories() {
        Intent intent = new Intent(StartHereActivity.newIntent(itemView.getContext()));
        itemView.getContext().startActivity(intent);

    }


}
