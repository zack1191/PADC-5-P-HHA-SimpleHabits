package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.adapters.CategoriesProgramAdapter;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/18/2018.
 */

public class CategoriesProgramViewHolder extends BaseViewHolder<CategoriesProgramVO> {

    @BindView(R.id.rv_healty)
    RecyclerView rvHealthy;

    @BindView(R.id.tv_healty)
    TextView tvTitleHealthy;

    private CategoriesProgramAdapter mCategoriesProgramAdapter;
    private CategoriesProgramDelegate mCategoriesProgramDelegate;


    public CategoriesProgramViewHolder(View itemView, CategoriesProgramDelegate categoriesProgramDelegate) {
        super(itemView);

        ButterKnife.bind(this, itemView);
        mCategoriesProgramDelegate = categoriesProgramDelegate;


        mCategoriesProgramAdapter = new CategoriesProgramAdapter(itemView.getContext(), mCategoriesProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHealthy.setLayoutManager(linearLayoutManager);
        rvHealthy.setAdapter(mCategoriesProgramAdapter);
    }

    @Override
    public void setData(CategoriesProgramVO data) {
        tvTitleHealthy.setText(data.getTitle());
        mCategoriesProgramAdapter.setNewData(data.getPrograms());
        mCategoriesProgramAdapter.setCategory(data);
    }


}
