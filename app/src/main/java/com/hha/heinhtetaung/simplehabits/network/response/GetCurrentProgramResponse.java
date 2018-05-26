package com.hha.heinhtetaung.simplehabits.network.response;

/**
 * Created by E5 on 5/25/2018.
 */

import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;

import java.util.List;


public class GetCurrentProgramResponse {


    private int code;
    private String message;
    private String apiVersion;
    private CurrentProgramVO currentProgram;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
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

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }
}
