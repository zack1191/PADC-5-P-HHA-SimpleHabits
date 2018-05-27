package com.hha.heinhtetaung.simplehabits.event;

import com.hha.heinhtetaung.simplehabits.ShareParentVO;

import java.util.List;

/**
 * Created by E5 on 5/26/2018.
 */

public class LoadReadyDataEvent {
    private List<ShareParentVO> shareParentVO;

    public LoadReadyDataEvent(List<ShareParentVO> shareParentVO) {
        this.shareParentVO = shareParentVO;
    }

    public List<ShareParentVO> getShareParentVO() {
        return shareParentVO;
    }
}
