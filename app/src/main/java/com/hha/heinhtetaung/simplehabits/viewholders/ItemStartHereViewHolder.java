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

public class ItemStartHereViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_habit)
    TextView tvTitle;

    @BindView(R.id.btn_start)
    Button btnStart;

    public ItemStartHereViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        tvTitle.setText(currentProgram.getTitle());
        btnStart.setText(currentProgram.getCurrentPeriod());
    }

}
