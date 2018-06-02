package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.SessionsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/31/2018.
 */

public class SessionsViewHolder extends BaseViewHolder<SessionsVO> {


    @BindView(R.id.tv_sessions_title)
    TextView tvSessionTitle;

    @BindView(R.id.tv_sessions_long_time)
    TextView tvSessionLongTime;

    @BindView(R.id.tv_number)
    TextView tvNumber;

    public SessionsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void setData(SessionsVO data) {
        tvSessionTitle.setText(data.getTitle());
        tvNumber.setText(data.getSessionId());
        String lengthTime = data.getLengthInSeconds() / 60 + ":" + data.getLengthInSeconds() % 60;
        tvSessionLongTime.setText(lengthTime);
    }


}
