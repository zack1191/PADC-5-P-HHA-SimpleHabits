package com.hha.heinhtetaung.simplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by E5 on 5/23/2018.
 */

public class CategoriesProgramVO {
    @SerializedName("category-id")
    private String categoryId;

    private String title;

    private List<ProgramVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }
}
