package com.hha.heinhtetaung.simplehabits.network.response;

import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;

import java.util.List;

/**
 * Created by E5 on 5/26/2018.
 */

public class GetCategoriesResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<CategoriesProgramVO> categoriesPrograms;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesProgramVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesProgramVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }
}
