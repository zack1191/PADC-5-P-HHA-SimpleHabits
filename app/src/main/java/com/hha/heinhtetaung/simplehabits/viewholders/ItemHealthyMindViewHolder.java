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

public class ItemHealthyMindViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title_healthy)
    TextView tvTitleHealthy;

    @BindView(R.id.tv_healty_length)
    TextView tvLength;

    public ItemHealthyMindViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setCategories(CategoriesProgramVO categories) {
        tvTitleHealthy.setText(categories.getTitle());

    }
}
