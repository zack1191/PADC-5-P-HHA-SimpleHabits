package com.hha.heinhtetaung.simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 5/22/2018.
 */

public class ItemAllTopicViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_basic)
    TextView tvHeader;

    @BindView(R.id.tv_disc)
    TextView tvDisc;

    @BindView(R.id.iv_icon)
    ImageView ivIcon;

    @BindView(R.id.iv_topic_background)
    ImageView ivBackground;


    public ItemAllTopicViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void setTopic(TopicVO topic) {

        tvDisc.setText(topic.getTopicDesc());
        tvHeader.setText(topic.getTopicName());
        Glide.with(ivIcon.getContext())
                .load(topic.getIcon())
                .into(ivIcon);
        Glide.with(ivBackground.getContext())
                .load(topic.getBackground())
                .into(ivBackground);
    }


}
