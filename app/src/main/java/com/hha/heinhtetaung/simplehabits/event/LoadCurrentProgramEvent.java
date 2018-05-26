package com.hha.heinhtetaung.simplehabits.event;

import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by E5 on 5/25/2018.
 */

public class LoadCurrentProgramEvent {
    private CurrentProgramVO currentProgram;

    public LoadCurrentProgramEvent(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
