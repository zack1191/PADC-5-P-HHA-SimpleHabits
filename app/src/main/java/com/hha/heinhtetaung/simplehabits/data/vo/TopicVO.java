package com.hha.heinhtetaung.simplehabits.data.vo;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by E5 on 5/23/2018.
 */

public class TopicVO implements ShareParentVO {

    @SerializedName("topic-name")
    private String topicName;

    @SerializedName("topic-desc")
    private String topicDesc;

    private String icon;

    private String background;


    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackground() {
        return background;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
