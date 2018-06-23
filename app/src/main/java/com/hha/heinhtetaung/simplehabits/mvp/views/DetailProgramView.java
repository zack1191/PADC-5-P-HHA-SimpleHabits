package com.hha.heinhtetaung.simplehabits.mvp.views;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;

import java.util.List;

/**
 * Created by E5 on 6/22/2018.
 */

public interface DetailProgramView extends BaseView {
    void displayCurrentProgramDetail(CurrentProgramVO currentProgramVO);

    void displayCategoryProgramDetail(ProgramVO categoriesProgramVO);
}
