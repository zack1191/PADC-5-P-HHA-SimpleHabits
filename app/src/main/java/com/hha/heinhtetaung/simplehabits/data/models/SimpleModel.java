package com.hha.heinhtetaung.simplehabits.data.models;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadSimpleHabitEvent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsDataAgent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by E5 on 5/23/2018.
 */

public class SimpleModel {
    private static SimpleModel sObjInstance;

    private List<ShareParentVO> serisData;
    private static CurrentProgramVO mCurrentProgramVO;
    private static List<CategoriesProgramVO> mCategoriesProgramVO;
    private static List<TopicVO> mTopicVO;


    private SimpleModel() {

        EventBus.getDefault().register(this);
        mCurrentProgramVO = new CurrentProgramVO();
        serisData = new ArrayList<>();
        mCategoriesProgramVO = new ArrayList<>();
        mTopicVO = new ArrayList<>();


    }

    public List<ShareParentVO> getSerisData() {
        return serisData;
    }

    public static SimpleModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new SimpleModel();
        }
        return sObjInstance;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onDataloaded(LoadSimpleHabitEvent.LoadTopicEvent event) {
        serisData.addAll(event.getTopics());
        LoadReadyDataEvent loadReadyDataEvent = new LoadReadyDataEvent(serisData);
        EventBus.getDefault().post(loadReadyDataEvent);

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCureentProgramLoaded(LoadSimpleHabitEvent.LoadCurrentProgramEvent event) {
        CurrentProgramVO currentProgramV0 = event.getCurrentProgram();
        serisData.add(currentProgramV0);
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadCategoriesProgram();


    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesLoaded(LoadSimpleHabitEvent.LoadCategoriesEvent event) {
        serisData.addAll(event.getCategoriesProgram());
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadTopic();

    }


    public void loadDatas() {
        SimpleHabitsRetrofitDataAgent.getsObjInstance().loadCurrentProgram();

    }

//    public ProgramVO getProgramByProgramId(String programId) {
//        ProgramVO programVO = null;
//        for (int i = 0; i < serisData.size(); i++) {
//            if (serisData.get(i) instanceof CategoriesProgramVO) {
//                for (int j = 0; j < ((CategoriesProgramVO) serisData.get(i)).getPrograms().size(); j++) {
//                    String id = ((CategoriesProgramVO) serisData.get(i)).getPrograms().get(j).getProgramId();
//                    if (id.equals(programId))
//                        programVO = ((CategoriesProgramVO) serisData.get(i)).getPrograms().get(j);
//                }
//            }
//        }
//        return programVO;
//    }

    //    public CurrentProgramVO getProgramsByProgramId(String programId) {
//        CurrentProgramVO currentProgramVO = null;
//        for (int i = 0; i < serisData.size(); i++) {
//            if (serisData.get(i) instanceof CurrentProgramVO) {
//                if (((CurrentProgramVO) serisData.get(i)).getProgramId().equals(programId))
//                    currentProgramVO = (CurrentProgramVO) serisData.get(i);
//          return currentProgramVO;
//    }    }
//        }
//
    public CurrentProgramVO getCurrentProgram() {
        for (ShareParentVO obj : serisData) {
            if (obj instanceof CurrentProgramVO)
                return (CurrentProgramVO) obj;
        }
        return null;
    }

    public ProgramVO getProgram(String categoryId, String categoryProgramId) {
        for (int i = 0; i < serisData.size(); i++) {
            if (serisData.get(i) instanceof CategoriesProgramVO) {
                if (((CategoriesProgramVO) serisData.get(i)).getCategoryId().equals(categoryId)) {
                    for (int j = 0; j < ((CategoriesProgramVO) serisData.get(i)).getPrograms().size(); j++) {
                        if (((CategoriesProgramVO) serisData.get(i)).getPrograms().get(j).getProgramId().equals(categoryProgramId)) {
                            return ((CategoriesProgramVO) serisData.get(i)).getPrograms().get(j);
                        }
                    }
                }
            }
        }
        return null;
    }

}
