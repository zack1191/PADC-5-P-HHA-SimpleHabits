package com.hha.heinhtetaung.simplehabits.data.models;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.event.LoadReadyDataEvent;
import com.hha.heinhtetaung.simplehabits.event.LoadSimpleHabitEvent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsDataAgent;
import com.hha.heinhtetaung.simplehabits.network.SimpleHabitsRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by E5 on 5/23/2018.
 */

public class SimpleModel {
    private static SimpleModel sObjInstance;

    private List<ShareParentVO> serisData;


    private SimpleModel() {

        EventBus.getDefault().register(this);
        serisData = new ArrayList<>();

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
        serisData.add(event.getCurrentProgram());
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


}
