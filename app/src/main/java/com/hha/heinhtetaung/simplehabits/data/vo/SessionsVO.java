package com.hha.heinhtetaung.simplehabits.data.vo;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;

/**
 * Created by E5 on 5/23/2018.
 */

public class SessionsVO implements ShareParentVO {
    @SerializedName("session-id")
    private String sessionId;

    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
