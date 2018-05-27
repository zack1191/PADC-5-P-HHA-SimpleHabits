package com.hha.heinhtetaung.simplehabits.data.vo;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;

import java.util.List;

/**
 * Created by E5 on 5/23/2018.
 */

public class ProgramVO {

    @SerializedName("program-id")
    private String programId;

    private String title;

    private String image;

    private String description;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

    private List<SessionsVO> sessions;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public void setAverageLengths(List<Integer> averageLengths) {
        this.averageLengths = averageLengths;
    }

    public List<SessionsVO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionsVO> sessions) {
        this.sessions = sessions;
    }


}
