package com.hha.heinhtetaung.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.SessionsVO;
import com.hha.heinhtetaung.simplehabits.viewholders.BaseViewHolder;
import com.hha.heinhtetaung.simplehabits.viewholders.SessionsViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 5/31/2018.
 */

public class SessionsAdapter extends BaseRecyclerAdapter<SessionsViewHolder, SessionsVO> {


    public SessionsAdapter(Context context) {
        super(context);

    }

    @NonNull
    @Override
    public SessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.item_sessions, parent, false);
        return new SessionsViewHolder(view);
    }


}
