package com.hha.heinhtetaung.simplehabits.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;
import com.hha.heinhtetaung.simplehabits.delegate.SimpleHabitsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 5/22/2018.
 */

public class ItemAllTopicViewHolder extends BaseViewHolder<TopicVO> {
    @BindView(R.id.tv_basic)
    TextView tvHeader;

    @BindView(R.id.tv_disc)
    TextView tvDisc;

    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    @BindView(R.id.iv_topic_background)
    ImageView ivBackground;
    private SimpleHabitsDelegate mCurrentProgramDelegate;


    public ItemAllTopicViewHolder(View itemView, SimpleHabitsDelegate currentProgramDelegate) {

        super(itemView);
        ButterKnife.bind(this, itemView);
        mCurrentProgramDelegate = currentProgramDelegate;

    }

    @Override
    public void setData(TopicVO data) {
        tvDisc.setText(data.getTopicDesc());
        tvHeader.setText(data.getTopicName());
    }

    @OnClick(R.id.rl_topics)
    public void onTapItemTopic() {
        mCurrentProgramDelegate.onTapTopic();

    }


}
