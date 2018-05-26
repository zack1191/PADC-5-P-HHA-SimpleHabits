package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;
import com.hha.heinhtetaung.simplehabits.viewholders.AllTopicViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.BaseViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemAllTopicViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/18/2018.
 */

public class AllTopicAdapter extends RecyclerView.Adapter<ItemAllTopicViewHolder> {
    private List<TopicVO> mTopics;

    public AllTopicAdapter() {
        mTopics = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemAllTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_all_topic, parent, false);
        return new ItemAllTopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAllTopicViewHolder holder, int position) {
        holder.setTopic(mTopics.get(position));
    }


    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    public void setTopics(List<TopicVO> topicsList) {

        mTopics = topicsList;
        notifyDataSetChanged();


    }

}
