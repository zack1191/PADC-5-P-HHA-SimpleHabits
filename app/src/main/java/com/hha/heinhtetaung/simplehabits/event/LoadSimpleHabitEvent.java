package com.hha.heinhtetaung.simplehabits.event;

import com.hha.heinhtetaung.simplehabits.data.vo.CategoriesProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.CurrentProgramVO;
import com.hha.heinhtetaung.simplehabits.data.vo.TopicVO;

import java.util.List;

/**
 * Created by E5 on 5/26/2018.
 */

public class LoadSimpleHabitEvent {

    public static class LoadCategoriesEvent {

        private List<CategoriesProgramVO> categoriesProgram;

        public LoadCategoriesEvent(List<CategoriesProgramVO> categoriesProgram) {
            this.categoriesProgram = categoriesProgram;
        }

        public List<CategoriesProgramVO> getCategoriesProgram() {
            return categoriesProgram;
        }
    }

    public static class LoadCurrentProgramEvent {
        private CurrentProgramVO currentProgram;

        public LoadCurrentProgramEvent(CurrentProgramVO currentProgram) {
            this.currentProgram = currentProgram;
        }

        public CurrentProgramVO getCurrentProgram() {
            return currentProgram;
        }
    }

    public static class LoadTopicEvent {
        private List<TopicVO> topic;


        public LoadTopicEvent(List<TopicVO> topics) {

            this.topic = topics;
        }

        public List<TopicVO> getTopics() {
            return topic;
        }


    }

}
