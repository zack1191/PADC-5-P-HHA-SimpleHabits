package com.hha.heinhtetaung.simplehabits.mvp.views;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;

import java.util.List;

/**
 * Created by E5 on 6/21/2018.
 */

public interface SeriesView extends BaseView {
    void displaySeriesData(List<ShareParentVO> mShareParentVO);

    void launchDetailsCurrentProgram();

    void launchDetailCategoriesProgram(String categoryId, String categoryItemId);
}
