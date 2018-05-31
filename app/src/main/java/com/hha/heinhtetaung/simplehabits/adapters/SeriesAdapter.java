package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.viewholders.BaseViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.CategoriesProgramViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemAllTopicViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemCurrentProgramViewHolder;

/**
 * Created by E5 on 5/22/2018.
 */

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, ShareParentVO> {


    private static final int START_HERE = 0;
    private static final int HEALTHY_MIND = 1;
    private static final int ALL_TOPICS = 2;

    private CurrentProgramDelegate mCurrentProgramDelegate;



    public SeriesAdapter(Context context, CurrentProgramDelegate mCurrentProgramDelegate) {
        super(context);
        this.mCurrentProgramDelegate = mCurrentProgramDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case START_HERE:
                viewHolder = new ItemCurrentProgramViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_start_here, parent, false), mCurrentProgramDelegate);
                break;
            case HEALTHY_MIND:
                viewHolder = new CategoriesProgramViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_healthy_mind, parent, false));
                break;

            case ALL_TOPICS:
                viewHolder = new ItemAllTopicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_topic, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }


    @Override
    public int getItemViewType(int position) {
//        int i = 0;
//        switch (position) {
//            case 0:
//                i = START_HERE;
//                break;
//            case 1:
//                i = HEALTHY_MIND;
//                break;
//
//            case 4:
//                i = ALL_TOPICS;
//                break;
//        }return position;
        if (mData.get(position) instanceof CurrentProgramVO) {
            return START_HERE;
        } else if (mData.get(position) instanceof CategoriesProgramVO) {
            return HEALTHY_MIND;
        } else if (mData.get(position) instanceof TopicVO) {
            return ALL_TOPICS;
        }
        return position;


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
