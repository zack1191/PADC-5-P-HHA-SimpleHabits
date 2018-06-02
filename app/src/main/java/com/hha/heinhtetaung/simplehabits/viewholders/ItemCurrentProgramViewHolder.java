package com.hha.heinhtetaung.simplehabits.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 5/26/2018.
 */

public class ItemCurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO> {
    @BindView(R.id.tv_habit)
    TextView tvTitle;

    @BindView(R.id.btn_start)
    Button btnStart;

    private CurrentProgramVO mCurrent;
    private CurrentProgramDelegate mCurrentProgramDelegate;

    public ItemCurrentProgramViewHolder(View itemView, CurrentProgramDelegate currentProgramDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCurrentProgramDelegate = currentProgramDelegate;
    }

    @Override
    public void setData(CurrentProgramVO data) {
        mCurrent = data;
        tvTitle.setText(data.getTitle());

        btnStart.setText(data.getCurrentPeriod());
    }

    @OnClick(R.id.btn_start)
    public void onTapCurrentProgram(View view) {
        mCurrentProgramDelegate.onTapStartHere();
    }


}
