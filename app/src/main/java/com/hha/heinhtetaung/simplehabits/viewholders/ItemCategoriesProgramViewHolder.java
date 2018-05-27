package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/22/2018.
 */

public class ItemCategoriesProgramViewHolder extends BaseViewHolder<ProgramVO> {
    @BindView(R.id.tv_title_healthy)
    TextView tvTitleHealthy;

    @BindView(R.id.tv_healty_length)
    TextView tvLength;

    public ItemCategoriesProgramViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ProgramVO data) {
        tvTitleHealthy.setText(data.getTitle());
    }


}
