package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemHealthyMindViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/22/2018.
 */

public class HealthyMindAdapter extends RecyclerView.Adapter<ItemHealthyMindViewHolder> {
    private List<CategoriesProgramVO> mCategoriesProgram;

    public HealthyMindAdapter() {
        mCategoriesProgram = new ArrayList<>();
    }

    public void setCategoriesProgram(List<CategoriesProgramVO> categoriesProgram) {
        mCategoriesProgram = categoriesProgram;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemHealthyMindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_healthy_mind, parent, false);
        ItemHealthyMindViewHolder itemHealthyMindViewHolder = new ItemHealthyMindViewHolder(view);
        return itemHealthyMindViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHealthyMindViewHolder holder, int position) {
        holder.setCategories(mCategoriesProgram.get(position));
    }


    @Override
    public int getItemCount() {
        return mCategoriesProgram.size();
    }
}
