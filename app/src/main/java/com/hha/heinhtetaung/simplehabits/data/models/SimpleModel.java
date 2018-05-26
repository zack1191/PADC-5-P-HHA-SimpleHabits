package com.hha.heinhtetaung.simplehabits.data.models;

import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;
import com.hha.heinhtetaung.simplehabits.event.LoadCategoriesEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadCurrentProgramEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadTopicEvent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsDataAgent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by E5 on 5/23/2018.
 */

public class SimpleModel {
    private static SimpleModel sObjInstance;

    private SimpleHabitsDataAgent mSimpleHabitsDataAgent;

    private List<TopicVO> mTopic;
    private CurrentProgramVO mCurrentProgram;

    private List<CategoriesProgramVO> mCategoriesProgram;

    private SimpleModel() {


        mSimpleHabitsDataAgent = SimpleHabitsRetrofitDataAgent.getsObjInstance();


    }

    public void loadData() {

        mSimpleHabitsDataAgent.loadTopic();

        mSimpleHabitsDataAgent.loadCurrentProgram();

        mSimpleHabitsDataAgent.loadCategoriesProgram();
//        EventBus.getDefault().register(this);
    }


    public static SimpleModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new SimpleModel();
        }
        return sObjInstance;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onDataloaded(LoadTopicEvent event) {
        mTopic.addAll(event.getTopics());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCureentProgramLoaded(LoadCurrentProgramEvent event) {

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesLoaded(LoadCategoriesEvent event) {
        mCategoriesProgram.addAll(event.getCategoriesProgram());

    }


}
