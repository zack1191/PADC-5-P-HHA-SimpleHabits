package com.hha.heinhtetaung.simplehabits.event;

import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.ProgramVO;

import java.util.List;

/**
 * Created by E5 on 5/26/2018.
 */

public class LoadCategoriesEvent {

    private List<CategoriesProgramVO> categoriesProgram;

    public LoadCategoriesEvent(List<CategoriesProgramVO> categoriesProgram) {
        this.categoriesProgram = categoriesProgram;
    }

    public List<CategoriesProgramVO> getCategoriesProgram() {
        return categoriesProgram;
    }
}
