package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemStartHereViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/26/2018.
 */

public class StartHereAdapter extends RecyclerView.Adapter<ItemStartHereViewHolder> {
    private List<CurrentProgramVO> currentProgram;

    public StartHereAdapter() {
        currentProgram = new ArrayList<>();
    }

    public void setCurrentProgram(List<CurrentProgramVO> currentProgram) {
        this.currentProgram = currentProgram;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemStartHereViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_start_here, parent, false);
        return new ItemStartHereViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemStartHereViewHolder holder, int position) {
//        holder.setCurrentProgram(currentProgram.get(position));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
