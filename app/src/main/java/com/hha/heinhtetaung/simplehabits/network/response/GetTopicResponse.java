package com.hha.heinhtetaung.simplehabits.network.response;

import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;

import java.util.List;

/**
 * Created by E5 on 5/23/2018.
 */

public class GetTopicResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<TopicVO> topics;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicVO> getTopics() {
        return topics;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setTopics(List<TopicVO> topics) {
        this.topics = topics;
    }
}
