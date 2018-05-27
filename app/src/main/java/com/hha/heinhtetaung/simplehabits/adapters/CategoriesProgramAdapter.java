package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.viewholders.ItemCategoriesProgramViewHolder;

/**
 * Created by E5 on 5/22/2018.
 */

public class CategoriesProgramAdapter extends BaseRecyclerAdapter<ItemCategoriesProgramViewHolder, ProgramVO> {

    public CategoriesProgramAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemCategoriesProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_healthy_mind, parent, false);
        return new ItemCategoriesProgramViewHolder(view);
    }
}
