package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/26/2018.
 */

public class ItemCurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO> {
    @BindView(R.id.tv_habit)
    TextView tvTitle;

    @BindView(R.id.btn_start)
    Button btnStart;

    public ItemCurrentProgramViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(CurrentProgramVO data) {
        tvTitle.setText(data.getTitle());
        btnStart.setText(data.getCurrentPeriod());
    }


}
