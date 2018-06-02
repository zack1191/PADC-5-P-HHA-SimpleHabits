package com.hha.heinhtetaung.simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.simplehabits.R;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.SimpleHabitsDelegate;

import java.util.Date;

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

    private SimpleHabitsDelegate mDelegate;

    public ItemCategoriesProgramViewHolder(View itemView,SimpleHabitsDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = delegate;


    }
    @OnClick(R.id.cv_category)
    public void onTapCategoryItem(View view ){
        mDelegate.onTapCategories();
    }

    @Override
    public void setData(ProgramVO data) {
        tvTitleHealthy.setText(data.getTitle());
    }


}
