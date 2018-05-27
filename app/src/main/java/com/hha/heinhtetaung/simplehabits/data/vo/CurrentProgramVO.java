package com.hha.heinhtetaung.simplehabits.data.vo;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.simplehabits.ShareParentVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by E5 on 5/23/2018.
 */

public class CurrentProgramVO implements ShareParentVO{
    @SerializedName("program-id")
    private String programId;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    private String description;

    @SerializedName("average-lengths")
    private List<Integer> averageLengths;

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

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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


}
