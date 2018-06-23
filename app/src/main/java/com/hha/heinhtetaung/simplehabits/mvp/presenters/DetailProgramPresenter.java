package com.hha.heinhtetaung.simplehabits.mvp.presenters;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.SimpleHabitApp;
import com.hha.heinhtetaung.simplehabits.data.models.SimpleModel;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.delegate.CategoriesProgramDelegate;
import com.hha.heinhtetaung.simplehabits.delegate.CurrentProgramDelegate;
import com.hha.heinhtetaung.simplehabits.mvp.views.DetailProgramView;

/**
 * Created by E5 on 6/22/2018.
 */


public class DetailProgramPresenter extends BasePresenter<DetailProgramView> {
    private ShareParentVO mShareParentVO;
    private SimpleModel mSimpleModel;


    public DetailProgramPresenter(DetailProgramView mView) {
        super(mView);
        mSimpleModel = SimpleModel.getsObjInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void onFinishedUiComponent(String viewType, String categoryId, String categoryProgramId) {
        if (viewType.equals(SimpleHabitApp.CATEGORY)) {
            ProgramVO categoriesProgramVO = mSimpleModel.getCategoriesProgramsItemVO(categoryId, categoryProgramId);
            mView.displayCategoryProgramDetail(categoriesProgramVO);
        } else if (viewType.equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramVO currentProgramVO = mSimpleModel.getCurrentProgram();
            mView.displayCurrentProgramDetail(currentProgramVO);

        }
    }

}
