package com.hha.heinhtetaung.simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 5/22/2018.
 */

public class ItemCategoriesProgramViewHolder extends BaseViewHolder<ProgramVO> {


    @BindView(R.id.tv_title_healthy)
    TextView tvTitleHealthy;

    @BindView(R.id.tv_healty_length)
    TextView tvLength;

    private CategoriesProgramDelegate mDelegate;

    private ProgramVO programVO;
    private CategoriesProgramVO mCategoriesProgramVO;

    public ItemCategoriesProgramViewHolder(View itemView, CategoriesProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = delegate;


    }

    @OnClick(R.id.cv_category)
    public void onTapCategoryItem(View view) {
        mDelegate.onTapCategories(mCategoriesProgramVO.getCategoryId(),programVO.getProgramId());//data yae id ko u tr
    }

    @Override
    public void setData(ProgramVO data) {
        programVO = data;
        tvTitleHealthy.setText(data.getTitle());
    }

    public void setCategory(CategoriesProgramVO category) {
        mCategoriesProgramVO = category;
    }


}
