package com.hha.heinhtetaung.simplehabits.event;

import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by E5 on 5/23/2018.
 */

public class LoadTopicEvent {
    private List<TopicVO> topic;


    public LoadTopicEvent(List<TopicVO> topics) {

        this.topic = topics;
    }

    public List<TopicVO> getTopics() {
        return topic;
    }


}
