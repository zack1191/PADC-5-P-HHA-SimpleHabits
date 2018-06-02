package com.hha.heinhtetaung.simplehabits.delegate;

import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;

/**
 * Created by E5 on 5/27/2018.
 */

public interface SimpleHabitsDelegate {
    void onTapStartHere(CurrentProgramVO tappedCurrent);

    void onTapTopic();

    void onTapCategories();
}
